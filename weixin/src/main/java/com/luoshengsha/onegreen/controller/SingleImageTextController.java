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

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.SingleImageText;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.service.SingleImageTextService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 单图文回复控制器
 * @author luoshengsha
 * @date 2014年9月30日 下午4:10:19
 */
@Controller
public class SingleImageTextController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(SingleImageTextController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private SingleImageTextService imageTextService;
    @Resource
    private ImageService imageService;
    
    /**
     * 单图文回复列表
     * @return
     */
    @RequestMapping(value="/center/singleImageText/list.htm")
    public ModelAndView list(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
			//页码，每页显示10个多图文回复
			PageView<SingleImageText> pageView = new PageView<SingleImageText>(pageNo, 1);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<SingleImageText> qr = imageTextService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			//若本页无数据，则显示最后一页
			if(pageView.getRecords().isEmpty() && pageNo > 1) {
				return new ModelAndView("redirect:/center/singleImageText/list.htm", "pageNo", pageView.getTotalpage()==0 ? 1 : pageView.getTotalpage());
			}
			
			return new ModelAndView("center/singleImageText-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示单图文回复列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 添加单图文回复界面
     * @return
     */
    @RequestMapping(value="/center/singleImageText/new.htm")
    public String addui() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return "redirect:/center/platform.htm";
		}
    	return "center/singleImageText-new";
    }
    
    /**
     * 保存
     * @param keywords
     * @param content
     * @param imageId
     */
    @RequestMapping(value="/center/singleImageText/save.htm")
    public ModelAndView save(@RequestParam(value="keywords") String keywords, 
    				@RequestParam(value="title") String title, 
    				@RequestParam(value="content") String content, 
    				@RequestParam(value="attachId") String imageId) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			
			SingleImageText imageText = new SingleImageText();
			imageText.setUuid(IdGenerator.generateId());
			imageText.setKeywords(keywords);
			imageText.setTitle(title);
			imageText.setImage(imageService.getByUuid(imageId));
			imageText.setContent(content);
			imageText.setCreateTime(new Date());
			imageText.setStatus(1);
			imageText.setPlatform(platform);
			
			imageTextService.save(imageText);
			
	    	return new ModelAndView("redirect:/center/singleImageText/success.htm");
		} catch (Exception e) {
			logger.error("保存单图文回复失败", e);
			return new ModelAndView("redirect:/center/singleImageText/failure.htm");
		}
    }
    
    /**
     * 编辑单图文回复
     * @param uuid
     */
    @RequestMapping(value="/center/singleImageText/edit.htm")
    public ModelAndView edit(@RequestParam(value="uuid") String uuid) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
			if(platform == null) {
				return new ModelAndView("redirect:/center/platform.htm");
			}
			SingleImageText imageText = imageTextService.getByUuid(uuid);
			if(imageText == null) {
				return new ModelAndView("404");
			}
			return new ModelAndView("center/singleImageText-edit", "imageText", imageText);
		} catch (Exception e) {
			logger.error("编辑单图文回复失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 
     * @param keywords
     * @param content
     * @param imageId
     * @param uuid
     */
    @RequestMapping(value="/center/singleImageText/update.htm")
    public ModelAndView update(@RequestParam(value="uuid") String uuid,
			@RequestParam(value="keywords") String keywords,
			@RequestParam(value="title") String title, 
			@RequestParam(value="content") String content,
			@RequestParam(value="attachId") String imageId) {
		try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
			if(platform == null) {
				return new ModelAndView("redirect:/center/platform.htm");
			}
			SingleImageText imageText = imageTextService.getByUuid(uuid);
			imageText.setKeywords(keywords);
			imageText.setTitle(title);
			imageText.setContent(content);
			imageText.setImage(imageService.getByUuid(imageId));
			imageText.setEditTime(new Date());
			imageTextService.update(imageText);
			
			return new ModelAndView("redirect:/center/singleImageText/success.htm", "uuid", uuid);
		} catch (Exception e) {
			logger.error("更新单图文回复失败", e);
			return new ModelAndView("redirect:/center/singleImageText/failure.htm", "uuid", uuid);
		}
	}
    
    /**
     * 根据uuid删除
     * @param uuid
     */
    @RequestMapping(value="/center/singleImageText/delete.htm")
    public void delete(@RequestParam(value="uuid") String uuid, HttpServletResponse response) {
    	try {
			imageTextService.delete(uuid);
			WebUtil.print2JsonMsg(response, true, "删除单图文成功！");
		} catch (Exception e) {
			logger.error("删除单图文失败！", e);
			WebUtil.print2JsonMsg(response, false, "删除单图文失败！");
		}
    }
    
    /**
     * 禁用单图文回复
     * @param uuid
     */
    @RequestMapping(value="/center/singleImageText/forbid.htm")
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
     * 启用单图文回复
     * @param uuid
     */
    @RequestMapping(value="/center/singleImageText/enable.htm")
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
    @RequestMapping(value="/center/singleImageText/success.htm")
    public String success(String message) {
    	return "center/singleImageText-success";
    }
    
    /**
     * 操作失败
     * @return
     */
    @RequestMapping(value="/center/singleImageText/failure.htm")
    public String failure(String message) {
    	return "center/singleImageText-failure";
    }
    
    /**
     * 查看详情
     * @param uuid
     * @param request
     * @return
     */
    @RequestMapping(value="/view/singleImageText/detail.htm")
    public ModelAndView detail(@RequestParam(value="uuid") String uuid, HttpServletRequest request) {
    	try {
			SingleImageText imageText = imageTextService.getByUuid(uuid);
			if(imageText == null) {
				return new ModelAndView("404");
			}
			
			return new ModelAndView("view/singleImageText-detail", "imageText", imageText);
		} catch (Exception e) {
			logger.error("查看单图文失败", e);
			return new ModelAndView("500");
		}
    }
}
