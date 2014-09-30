package com.luoshengsha.onegreen.test;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Activities;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ActivitiesService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 活动单元测试
 * @author luoshengsha
 * @date 2014年9月9日 下午11:37:09
 */
public class ActivitiesTest {
	protected static PlatformService platformService;
	protected static ActivitiesService activitiesService;
	protected static ImageService imageService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			activitiesService = (ActivitiesService)cxt.getBean("activitiesServiceImpl");
			imageService = (ImageService)cxt.getBean("imageServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存
	 */
	@Test
	public void save() {
		for(int i=1;i<30;i++) {
			Activities activities = new Activities();
			activities.setUuid(IdGenerator.generateId());
			activities.setTitle("中秋促销活动"+i);
			activities.setContent("中秋促销活动了！！！！");
			//activities.setImage(imageService.find(3));
			activities.setCreateTime(new Date());
			activities.setEditTime(new Date());
			activities.setPlatform(platformService.getByOriginalId("gh_3e7314baeab1"));
			
			activitiesService.save(activities);
		}
	}
	
	/**
	 * 更新
	 */
	@Test
	public void update() {
		Activities activities = activitiesService.find("B3A324970D5446F19F3A54AF1BCCEF2B");
		activities.setUuid(IdGenerator.generateId());
		activities.setTitle("中秋促销活动1111！");
		activities.setContent("中秋促销活动了！！！！");
		activities.setImage(imageService.find(3));
		activities.setCreateTime(new Date());
		activities.setEditTime(new Date());
		activities.setPlatform(platformService.getByOriginalId("gh_3e7314baeab1"));
		
		activitiesService.update(activities);
	}
	
	/**
	 * 查询
	 */
	@Test
	public void query() {
		PageView<Activities> pageView = new PageView<Activities>(1, 10);
		//条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		conditionMap.put("platform", platform);
		//排序
		LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
		
		QueryResult<Activities> qr = activitiesService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
		pageView.setQueryResult(qr);
		
		for(Activities activities : pageView.getRecords()) {
			System.out.println(activities.getTitle() + " " + activities.getContent() + " " + activities.getImage());
		}
	}
	
	/**
	 * 根据条件查询
	 */
	@Test
	public void getByCond() {
		//条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		conditionMap.put("platform", platform);
		//排序
		LinkedHashMap<String,String> orderBy = new LinkedHashMap<String,String>();
		orderBy.put("editTime", "desc");
		List<Activities> activitiesList = activitiesService.getByCond(conditionMap, orderBy, 5);
		for(Activities activities : activitiesList) {
			System.out.println(activities.getTitle() + " " + activities.getContent() + " " + activities.getEditTime() + " " + activities.getImage());
		}
	}
}
