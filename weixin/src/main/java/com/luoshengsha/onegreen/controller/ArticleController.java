package com.luoshengsha.onegreen.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ArticleService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 文章控制器
 * @author luoshengsha
 * @date 2014年9月11日 下午3:11:17
 */
@Controller
public class ArticleController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(ArticleController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private ArticleService articleService;
    @Resource
    private ImageService imageService;

    /**
     * 文章列表
     * @return
     */
    @RequestMapping(value="/center/article/list.htm")
    public ModelAndView list(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
			//页码，每页显示10个文章
			PageView<Article> pageView = new PageView<Article>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<Article> qr = articleService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			return new ModelAndView("center/article-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示文章列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 添加文章
     * @return
     */
    @RequestMapping(value="/center/article/new.htm")
    public String addui() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return "redirect:/center/platform.htm";
		}
    	return "center/article-new";
    }
    
    /**
     * 保存文章
     * @param article 文章
     * @return
     */
    @RequestMapping(value="/center/article/save.htm")
    public ModelAndView save(@RequestParam(value="title") String title,
    			@RequestParam(value="content") String content,
    			@RequestParam(value="attachId") String imageId) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			
			Article article = new Article();
			article.setUuid(IdGenerator.generateId());
			article.setPlatform(platform);
			article.setTitle(title);
			article.setContent(content);
			article.setImage(imageService.getByUuid(imageId));
			
			article.setCreateTime(new Date());
			article.setStatus(1);
			
			articleService.save(article);
			
			return new ModelAndView("redirect:/center/article/success.htm");
		} catch (Exception e) {
			logger.error("添加文章失败！", e);
			return new ModelAndView("redirect:/center/article/failure.htm");
		}
    }
    
    /**
     * 编辑文章
     * @param uuid
     * @return
     */
    @RequestMapping(value="/center/article/edit.htm")
    public ModelAndView edit(String uuid) {
    	try {
			Article article = articleService.getByUuid(uuid);
			if(article==null) {
				return new ModelAndView("404");
			}
			return new ModelAndView("center/article-edit", "article", article);
		} catch (Exception e) {
			logger.error("编辑文章失败！", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新文章
     * @param article
     * @return
     */
    @RequestMapping(value="/center/article/update.htm")
    public ModelAndView update(@RequestParam(value="uuid") String uuid,
    		@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="attachId") String imageId) {
    	try {
    		Article article = articleService.getByUuid(uuid);
			article.setTitle(title);
			article.setContent(content);
			article.setImage(imageService.getByUuid(imageId));
			article.setEditTime(new Date());
			
			articleService.update(article);
			return new ModelAndView("redirect:/center/article/success.htm", "uuid", uuid);
		} catch (Exception e) {
			logger.error("更新文章失败！", e);
			return new ModelAndView("redirect:/center/article/failure.htm", "uuid", uuid);
		}
    }
    
    /**
     * 删除文章
     * @param uuid 文章uuid
     */
    @ResponseBody
    @RequestMapping(value="/center/article/delete.htm")
    public void delete(String uuid, HttpServletResponse response) {
    	try {
			articleService.delete(uuid);
			WebUtil.print2JsonMsg(response, true, "删除文章成功！");
		} catch (Exception e) {
			logger.error("删除文章失败！", e);
			WebUtil.print2JsonMsg(response, false, "删除文章失败！");
		}
    }
    
    /**
     * 禁用文章
     * @param uuid
     */
    @RequestMapping(value="/center/article/forbid.htm")
    @ResponseBody
    public void forbid(String uuid, HttpServletResponse response) {
    	try {
    		articleService.forbid(uuid);
			
			WebUtil.print2JsonMsg(response, true, "禁用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "禁用失败！");
			logger.error("禁用文章失败！", e);
		}
    }
    
    /**
     * 启用文章
     * @param uuid
     */
    @RequestMapping(value="/center/article/enable.htm")
    @ResponseBody
    public void enable(String uuid, HttpServletResponse response) {
    	try {
    		articleService.enable(uuid);
			
			WebUtil.print2JsonMsg(response, true, "启用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "启用失败！");
			logger.error("启用文章失败！", e);
		}
    }
    
    /**
     * 操作成功
     * @return
     */
    @RequestMapping(value="/center/article/success.htm")
    public String success(String message) {
    	return "center/article-success";
    }
    
    /**
     * 操作失败
     * @return
     */
    @RequestMapping(value="/center/article/failure.htm")
    public String failure(String message) {
    	return "center/article-failure";
    }
    
    /**
     * 显示文章列表
     * @param pageNo 页码
     * @return
     */
    @RequestMapping(value="/view/article/list.htm")
    public ModelAndView list(@RequestParam(value="originalId") String originalId, 
    			@RequestParam(value="pageNo",defaultValue="1") int pageNo,
    			HttpServletRequest request) {
    	try {
    		Platform platform = platformService.getByOriginalId(originalId);
			//页码，每页显示10个文章
			PageView<Article> pageView = new PageView<Article>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<Article> qr = articleService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			request.setAttribute("platform", platform);
			
			return new ModelAndView("view/article-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示文章列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 显示文章详情
     * @param uuid
     * @return
     */
    @RequestMapping(value="/view/article/detail.htm")
    public ModelAndView detail(@RequestParam(value="uuid") String uuid, HttpServletRequest request) {
    	try {
			Article article = articleService.getByUuid(uuid);
			if(article == null) {
				return new ModelAndView("404");
			}
			request.setAttribute("platform", article.getPlatform());
			return new ModelAndView("view/article-detail", "article", article);
		} catch (Exception e) {
			logger.error("显示文章详情失败！", e);
			return new ModelAndView("500");
		}
    }
}
