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
			PageView<Activities> pageView = new PageView<Activities>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<Activities> qr = activitiesService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
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
    public ModelAndView update(Activities activities) {
    	try {
			Activities newActivities = activitiesService.getByUuid(activities.getUuid());
			newActivities.setTitle(activities.getTitle());
			newActivities.setContent(activities.getContent());
			newActivities.setImage(imageService.find(activities.getImage().getId()));
			newActivities.setValidDays(activities.getValidDays());
			
			Date date = new Date();
			newActivities.setEditTime(date);
			if(activities.getValidDays() != -1) {
				newActivities.setValidTime(new Date(date.getTime()+activities.getValidDays()*24*60*60*1000l));
			} else {
				//有效期为空，代表无期限
				newActivities.setValidTime(null);
			}
			return new ModelAndView("redirect:/center/activities/success.htm", "message", "更新活动成功！");
		} catch (Exception e) {
			logger.error("更新活动失败！", e);
			return new ModelAndView("redirect:/center/activities/failure.htm", "message", "更新活动失败！");
		}
    }
    
    /**
     * 添加活动页面
     * @return
     */
    @RequestMapping(value="/addui.htm")
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
    public ModelAndView save(Activities activities) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			activities.setPlatform(platform);
			activities.setUuid(IdGenerator.generateId());
			if(activities.getImage() != null) {
				activities.setImage(imageService.find(activities.getImage().getId()));
			}
			
			Date date = new Date();
			activities.setCreateTime(date);
			if(activities.getValidDays() != -1) {
				activities.setValidTime(new Date(date.getTime()+activities.getValidDays()*24*60*60*1000l));
			}
			
			activitiesService.save(activities);
			return new ModelAndView("redirect:/center/activities/success.htm", "message", "添加活动成功！");
		} catch (Exception e) {
			logger.error("添加活动失败！", e);
			return new ModelAndView("redirect:/center/activities/failure.htm", "message", "添加活动失败！");
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
			activitiesService.forbid(uuid);
			WebUtil.print2JsonMsg(response, true, "删除活动成功！");
		} catch (Exception e) {
			logger.error("删除活动失败！", e);
			WebUtil.print2JsonMsg(response, false, "删除活动失败！");
		}
    }
    
    /**
     * 操作成功
     * @return
     */
    @RequestMapping(value="/success.htm")
    public ModelAndView success(String message) {
    	return new ModelAndView("center/activities-success", "message", message);
    }
    
    /**
     * 操作失败
     * @return
     */
    @RequestMapping(value="/failure.htm")
    public ModelAndView failure(String message) {
    	return new ModelAndView("center/activities-failure", "message", message);
    }
}
