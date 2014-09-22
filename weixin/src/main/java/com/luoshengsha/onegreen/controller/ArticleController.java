package com.luoshengsha.onegreen.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
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
@RequestMapping(value="/center/article")
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
    @RequestMapping(value="/list.htm")
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
    @RequestMapping(value="/addui.htm")
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
    @RequestMapping(value="/save.htm")
    public ModelAndView save(Article article) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			article.setPlatform(platform);
			article.setUuid(IdGenerator.generateId());
			if(article.getImage() != null) {
				article.setImage(imageService.find(article.getImage().getId()));
			}
			
			Date date = new Date();
			article.setCreateTime(date);
			article.setEditTime(date);
			article.setAutoReply(false);
			article.setStatus(1);
			
			articleService.save(article);
			return new ModelAndView("redirect:/center/article/success.htm", "message", "添加文章成功！");
		} catch (Exception e) {
			logger.error("添加文章失败！", e);
			return new ModelAndView("redirect:/center/article/failure.htm", "message", "添加文章失败！");
		}
    }
    
    /**
     * 编辑文章
     * @param uuid
     * @return
     */
    @RequestMapping(value="/edit.htm")
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
    @RequestMapping(value="/update.htm")
    public ModelAndView update(Article article) {
    	try {
    		Article newArticle = articleService.getByUuid(article.getUuid());
			newArticle.setTitle(article.getTitle());
			newArticle.setContent(article.getContent());
			newArticle.setImage(imageService.find(article.getImage().getId()));
			newArticle.setEditTime(new Date());
			
			return new ModelAndView("redirect:/center/article/success.htm", "message", "更新文章成功！");
		} catch (Exception e) {
			logger.error("更新文章失败！", e);
			return new ModelAndView("redirect:/center/article/failure.htm", "message", "更新文章失败！");
		}
    }
    
    /**
     * 删除文章
     * @param uuid 文章uuid
     */
    @ResponseBody
    @RequestMapping(value="/delete.htm")
    public void delete(String uuid, HttpServletResponse response) {
    	try {
			articleService.forbid(uuid);
			WebUtil.print2JsonMsg(response, true, "删除文章成功！");
		} catch (Exception e) {
			logger.error("删除活动失败！", e);
			WebUtil.print2JsonMsg(response, false, "删除文章失败！");
		}
    }
}
