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

import com.luoshengsha.onegreen.bean.Activities;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ActivitiesService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 活动控制器
 * @author luoshengsha
 * @date 2014年9月11日 下午1:24:00
 */
@Controller
@RequestMapping(value="/center/activities")
public class ActivitiesController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(ActivitiesController.class);
	
    @Resource
    private PlatformService platformService;
    @Resource
    private ActivitiesService activitiesService;
    @Resource
    private ImageService imageService;
    
    /**
     * 活动列表
     * @param pageNo 页码
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
			//页码，每页显示10个活动
			PageView<Activities> pageView = new PageView<Activities>(pageNo, 1);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<Activities> qr = activitiesService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			//若本页无数据，则显示最后一页
			if(pageView.getRecords().isEmpty() && pageNo > 1) {
				return new ModelAndView("redirect:/center/activities/list.htm", "pageNo", pageView.getTotalpage()==0 ? 1 : pageView.getTotalpage());
			}
			
			return new ModelAndView("center/activities-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示活动列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 编辑活动
     * @param uuid 活动uuid
     * @return
     */
    @RequestMapping(value="/edit.htm")
    public ModelAndView edit(@RequestParam(value="uuid") String uuid) {
    	try {
			Activities activities = activitiesService.getByUuid(uuid);
			return new ModelAndView("center/activities-edit", "activities", activities);
		} catch (Exception e) {
			logger.error("编辑活动信息发生错误！", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新活动
     * @param activities
     * @return
     */
    @RequestMapping(value="/update.htm")
    public ModelAndView update(Activities activities, String attachId) {
    	try {
			Activities newActivities = activitiesService.getByUuid(activities.getUuid());
			newActivities.setTitle(activities.getTitle());
			newActivities.setContent(activities.getContent());
			newActivities.setImage(imageService.getByUuid(attachId));
			newActivities.setStartTime(activities.getStartTime());
			newActivities.setEndTime(activities.getEndTime());
			
			activitiesService.update(newActivities);
			
			return new ModelAndView("redirect:/center/activities/success.htm", "uuid", activities.getUuid());
		} catch (Exception e) {
			logger.error("更新活动失败！", e);
			return new ModelAndView("redirect:/center/activities/failure.htm", "uuid", activities.getUuid());
		}
    }
    
    /**
     * 添加活动页面
     * @return
     */
    @RequestMapping(value="/new.htm")
    public String addui() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return "redirect:/center/platform.htm";
		}
    	return "center/activities-new";
    }
    
    /**
     * 保存活动
     * @param activities 活动信息
     * @return
     */
    @RequestMapping(value="/save.htm")
    public ModelAndView save(Activities activities, String attachId) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			activities.setPlatform(platform);
			activities.setUuid(IdGenerator.generateId());
			activities.setCreateTime(new Date());
			activities.setImage(imageService.getByUuid(attachId));
			
			activitiesService.save(activities);
			return new ModelAndView("redirect:/center/activities/success.htm");
		} catch (Exception e) {
			logger.error("添加活动失败！", e);
			return new ModelAndView("redirect:/center/activities/failure.htm");
		}
    }
    
    /**
     * 根据uuid删除活动
     * @param uuid
     */
    @ResponseBody
    @RequestMapping(value="/delete.htm")
    public void delete(String uuid, HttpServletResponse response) {
    	try {
			activitiesService.delete(uuid);
			WebUtil.print2JsonMsg(response, true, "删除活动成功！");
		} catch (Exception e) {
			logger.error("删除活动失败！", e);
			WebUtil.print2JsonMsg(response, false, "删除活动失败！");
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
    		activitiesService.forbid(uuid);
			
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
    		activitiesService.enable(uuid);
			
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
    	return "center/activities-success";
    }
    
    /**
     * 操作失败
     * @return
     */
    @RequestMapping(value="/failure.htm")
    public String failure(String message) {
    	return "center/activities-failure";
    }
}
