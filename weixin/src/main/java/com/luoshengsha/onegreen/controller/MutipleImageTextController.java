package com.luoshengsha.onegreen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.MutipleImageText;
import com.luoshengsha.onegreen.service.ArticleService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.service.MutipleImageTextService;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 多图文回复控制器
 * @author luoshengsha
 * @date 2014年9月11日 下午4:32:46
 */
@Controller
@RequestMapping(value="/center/mutipleImageText")
public class MutipleImageTextController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(MutipleImageTextController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private MutipleImageTextService imageTextService;
    @Resource
    private ArticleService articleService;
	
    /**
     * 图文回复列表
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
			//页码，每页显示10个多图文回复
			PageView<MutipleImageText> pageView = new PageView<MutipleImageText>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<MutipleImageText> qr = imageTextService.query(pageView.getFirstResult(), pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			return new ModelAndView("center/mutipleImageText-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示多图文回复列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 添加多图文回复界面
     * @return
     */
    @RequestMapping(value="/new.htm")
    public String addui() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return "redirect:/center/platform.htm";
		}
    	return "center/mutipleImageText-new";
    }
    
    /**
     * 保存多图文回复
     * @param keywords
     * @param articleIds
     * @return
     */
    @RequestMapping(value="/save.htm")
    public ModelAndView save(@RequestParam(value="keywords") String keywords, 
    		@RequestParam(value="articleId") String articleIds) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			
			MutipleImageText imageText = new MutipleImageText();
			imageText.setKeywords(keywords);
			
			Date date = new Date();
			imageText.setCreateTime(date);
			imageText.setEditTime(date);
			imageText.setPlatform(platform);
			imageText.setStatus(1);
			
			//文章列表
			List<Article> articleList = new ArrayList<Article>();
			if(!StringUtils.isEmpty(articleIds)) {
				String [] articleIdArray = articleIds.split(",");
				for(int i=0,j=articleIdArray.length; i<j; i++) {
					Article article = articleService.getByUuid(articleIdArray[i]);
					articleList.add(article);
				}
			}
			imageText.setArticles(articleList);
			
			imageTextService.save(imageText);
			
			return new ModelAndView("redirect:/center/mutipleImageText/success.htm");
		} catch (Exception e) {
			logger.error("保存多图文回复失败！", e);
			return new ModelAndView("redirect:/center/mutipleImageText/failure.htm");
		}
    }
    
    /**
     * 根据uuid获取多图文回复
     * @param uuid
     */
    @RequestMapping(value="/edit.htm")
    public ModelAndView edit(String uuid) {
    	try {
			MutipleImageText imageText = imageTextService.getByUuid(uuid);
			if(imageText == null) {
				return new ModelAndView("404");
			}
			return new ModelAndView("center/mutipleImageText-edit", "imageText", imageText);
		} catch (Exception e) {
			logger.error("根据uuid获取多图文回复失败！", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新多图文回复
     * @param uuid
     * @param keywords
     * @param articleIds
     */
    @RequestMapping(value="/update.htm")
    public ModelAndView update(@RequestParam(value="uuid") String uuid,
    		@RequestParam(value="keywords") String keywords, 
    		@RequestParam(value="articleId") String articleIds) {
    	try {
			MutipleImageText imageText = imageTextService.getByUuid(uuid);
			imageText.setKeywords(keywords);
			
			imageText.setEditTime(new Date());
			
			//文章列表
			List<Article> articleList = new ArrayList<Article>();
			if(!StringUtils.isEmpty(articleIds)) {
				String [] articleIdArray = articleIds.split(",");
				for(int i=0,j=articleIdArray.length; i<j; i++) {
					Article article = articleService.getByUuid(articleIdArray[i]);
					articleList.add(article);
				}
			}
			imageText.setArticles(articleList);
			
			imageTextService.update(imageText);
			
			return new ModelAndView("redirect:/center/mutipleImageText/success.htm", "uuid", uuid);
		} catch (Exception e) {
			logger.error("更新多图文回复失败", e);
			return new ModelAndView("redirect:/center/mutipleImageText/failure.htm", "uuid", uuid);
		}
    }
    
    /**
     * 删除
     * @param uuid
     */
    @RequestMapping(value="/delete.htm")
    public void delete(String uuid, HttpServletResponse response) {
    	try {
			imageTextService.delete(uuid);
			WebUtil.print2JsonMsg(response, true, "删除成功！");
		} catch (Exception e) {
			logger.error("删除失败", e);
			WebUtil.print2JsonMsg(response, false, "删除失败！");
		}
    }
    
    /**
     * 禁用活动
     * @param uuid
     */
    @RequestMapping(value="/forbid.htm")
    @ResponseBody
    public void forbid(String uuid, HttpServletResponse response) {
    	try {
    		imageTextService.forbid(uuid);
			
			WebUtil.print2JsonMsg(response, true, "禁用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "禁用失败！");
			logger.error("禁用自动文本回复失败！", e);
		}
    }
    
    /**
     * 启用活动
     * @param uuid
     */
    @RequestMapping(value="/enable.htm")
    @ResponseBody
    public void enable(String uuid, HttpServletResponse response) {
    	try {
    		imageTextService.enable(uuid);
			
			WebUtil.print2JsonMsg(response, true, "启用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "启用失败！");
			logger.error("启用自动文本回复失败！", e);
		}
    }
    
    /**
     * 操作成功
     * @return
     */
    @RequestMapping(value="/success.htm")
    public String success(String message) {
    	return "center/mutipleImageText-success";
    }
    
    /**
     * 操作失败
     * @return
     */
    @RequestMapping(value="/failure.htm")
    public String failure(String message) {
    	return "center/mutipleImageText-failure";
    }
}
