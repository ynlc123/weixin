package com.luoshengsha.onegreen.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Fans;
import com.luoshengsha.onegreen.service.FansService;
import com.luoshengsha.onegreen.service.PlatformService;

/**
 * 粉丝单元测试
 * 
 * 说明：暂时还没有办法测试，等待公众号的开通
 * @author luoshengsha
 * @date 2014年9月8日 下午10:13:30
 */
public class FansTest {
	protected static PlatformService platformService;
	protected static FansService fansService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			fansService = (FansService)cxt.getBean("fansServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void save() {
		Fans fans = new Fans();
	}
}
