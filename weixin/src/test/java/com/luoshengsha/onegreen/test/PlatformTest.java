package com.luoshengsha.onegreen.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;

/**
 * 公众平台单元测试
 * @author luoshengsha
 * @date 2014年9月7日 下午11:45:57
 */
public class PlatformTest {
	protected static PlatformService platformService;
	protected static CustomerService customerService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			customerService = (CustomerService)cxt.getBean("customerServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑公众平台信息
	 */
	@Test
	public void edit() {
		Platform platform = platformService.getByOriginalId("luo_shengsha");
		if(platform == null) {
			platform = new Platform();
		}
		platform.setUuid(IdGenerator.generateId());
		platform.setOriginalId("gh_3e7314baeab1");
		platform.setPlatformNo("luo_shengsha");
		platform.setUserName("ynlc123@163.com");
		platform.setPassword("123456");
		platform.setAppId("8293iouoidsu8f234");
		platform.setAppSecret("lkjsdl3243lkksdj9832u49329jdf");
		
		Customer customer = customerService.find(1);
		platform.setCustomer(customer);
		
		platform.setCreateTime(new Date());
		platform.setValidTime(new Date(System.currentTimeMillis()+365*24*60*60*1000l));
		platform.setPlatformType(0);
		platform.setAuth(true);
		
		platformService.edit(platform);
	}
	
	@Test
	public void getByCustomer() {
		Customer customer = customerService.find(1);
		Platform platform = platformService.getByCustomer(customer);
		System.out.println(platform.getAppId());
	}
}
