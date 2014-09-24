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

import com.luoshengsha.onegreen.bean.AutoReplyText;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.AutoReplyTextService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 自动文本回复控制器
 * @author luoshengsha
 * @date 2014年9月23日 下午11:28:36
 */
@Controller
public class AutoReplyTextController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(AutoReplyTextController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private AutoReplyTextService autoReplyTextService;
	
    /**
     * 自动文本回复列表
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/list.htm")
    public ModelAndView list(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
			//页码，每页显示10个自动文本回复
			PageView<AutoReplyText> pageView = new PageView<AutoReplyText>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("createTime", "desc");
			
			QueryResult<AutoReplyText> qr = autoReplyTextService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			//若本页无数据，则显示前一页
			if(pageView.getRecords().isEmpty() && pageNo > 1) {
				return new ModelAndView("redirect:/center/autoReplyText/list.htm", "pageNo", pageNo-1);
			}
			
			return new ModelAndView("center/autoReplyText-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示自动文本回复列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 新增文本回复
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/new.htm")
    public String addui() {
    	return "center/autoReplyText-new";
    }
    
    /**
     * 保存文本回复
     * @param keywords 关键词
     * @param content 回复内容
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/save.htm")
    public String save(@RequestParam(value="keywords") String keywords, 
    		@RequestParam(value="content") String content) {
    	try {
			//获取登录客户的公众号信息
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			//自动文本回复
			AutoReplyText autoReplyText = new AutoReplyText();
			autoReplyText.setUuid(IdGenerator.generateId());
			autoReplyText.setKeywords(keywords);
			autoReplyText.setContent(content);
			autoReplyText.setCreateTime(new Date());
			autoReplyText.setStatus(1);
			autoReplyText.setPlatform(platform);
			
			autoReplyTextService.save(autoReplyText);
			
			return "redirect:/center/autoReplyText/success.htm";
		} catch (Exception e) {
			logger.error("保存文本回复失败！", e);
			return "redirect:/center/autoReplyText/failure.htm";
		}
    }
    
    /**
     * 编辑
     * @param uuid
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/edit.htm")
    public ModelAndView edit(String uuid) {
    	try {
			AutoReplyText autoReplyText = autoReplyTextService.getByUuid(uuid);
			if(autoReplyText == null) {
				return new ModelAndView("404");
			}
			return new ModelAndView("center/autoReplyText-edit", "autoReplyText", autoReplyText);
		} catch (Exception e) {
			logger.error("编辑文本回复失败！", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新文本回复
     * @param keywords 关键词
     * @param content 回复内容
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/update.htm")
    public ModelAndView update(@RequestParam(value="keywords") String keywords, 
    		@RequestParam(value="content") String content,
    		@RequestParam(value="uuid") String uuid) {
    	try {
			//自动文本回复
			AutoReplyText autoReplyText = autoReplyTextService.getByUuid(uuid);
			autoReplyText.setKeywords(keywords);
			autoReplyText.setContent(content);
			autoReplyText.setEditTime(new Date());
			
			autoReplyTextService.update(autoReplyText);
			
			return new ModelAndView("redirect:/center/autoReplyText/success.htm", "uuid", uuid);
		} catch (Exception e) {
			logger.error("保存文本回复失败！", e);
			return new ModelAndView("redirect:/center/autoReplyText/failure.htm", "uuid", uuid);
		}
    }
    
    /**
     * 保存文本回复成功页面
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/success.htm")
    public String success() {
    	return "center/autoReplyText-success";
    }
    
    /**
     * 保存文本回复失败页面
     * @return
     */
    @RequestMapping(value="/center/autoReplyText/failure.htm")
    public String failure() {
    	return "center/autoReplyText-failure";
    }
    
    /**
     * 禁用文本回复
     * @param uuid
     */
    @RequestMapping(value="/center/autoReplyText/forbid.htm")
    @ResponseBody
    public void forbid(String uuid, HttpServletResponse response) {
    	try {
			AutoReplyText autoReplyText = autoReplyTextService.getByUuid(uuid);
			autoReplyTextService.forbid(autoReplyText);
			
			WebUtil.print2JsonMsg(response, true, "禁用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "禁用失败！");
			logger.error("禁用自动文本回复失败！", e);
		}
    }
    
    /**
     * 启用文本回复
     * @param uuid
     */
    @RequestMapping(value="/center/autoReplyText/enable.htm")
    @ResponseBody
    public void enable(String uuid, HttpServletResponse response) {
    	try {
    		AutoReplyText autoReplyText = autoReplyTextService.getByUuid(uuid);
    		autoReplyTextService.enable(autoReplyText);
			
			WebUtil.print2JsonMsg(response, true, "启用成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "启用失败！");
			logger.error("启用自动文本回复失败！", e);
		}
    }
    
    /**
     * 删除文本回复
     * @param uuid
     * @param response
     */
    @RequestMapping(value="/center/autoReplyText/delete.htm")
    @ResponseBody
    public void delete(String uuid, HttpServletResponse response) {
    	try {
    		autoReplyTextService.delete(uuid);
			WebUtil.print2JsonMsg(response, true, "删除成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "删除失败！");
			logger.error("删除自动文本回复失败！", e);
		}
    }
}
