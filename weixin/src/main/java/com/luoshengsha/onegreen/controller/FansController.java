package com.luoshengsha.onegreen.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Fans;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.FansService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 粉丝控制器
 * @author luoshengsha
 * @date 2014年9月11日 上午10:37:06
 */
@Controller
public class FansController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(FansController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private FansService fansService;
    
    /**
     * 管理粉丝
     * @param pageNo
     * @return
     */
    @RequestMapping(value="/center/fans/list.htm")
    public ModelAndView manage(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
    		
			//页码，每页显示10个粉丝
			PageView<Fans> pageView = new PageView<Fans>(pageNo, 10);
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			
			conditionMap.put("platform", platform);
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			
			QueryResult<Fans> qr = fansService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			return new ModelAndView("center/fans-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示粉丝列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 根据openid获取粉丝详细信息
     * @param openid
     * @return
     */
    public ModelAndView detail(@RequestParam(value="openid") String openid) {
    	try {
			Fans fans = fansService.getByOpenid(openid);
			if(fans == null) {
				return new ModelAndView("400");
			}
			
			return new ModelAndView("center/fans-detail", "fans", fans);
		} catch (Exception e) {
			logger.error("获取粉丝信息失败", e);
			return new ModelAndView("500");
		}
    }
}
