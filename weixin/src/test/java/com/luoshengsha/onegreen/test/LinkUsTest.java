package com.luoshengsha.onegreen.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.LinkUs;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.LinkUsService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;

/**
 * 联系我们单元测试
 * @author luoshengsha
 * @date 2014年9月8日 上午11:44:04
 */
public class LinkUsTest {
	protected static PlatformService platformService;
	protected static LinkUsService linkUsService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			linkUsService = (LinkUsService)cxt.getBean("linkUsServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑
	 */
	@Test
	public void edit() {
		LinkUs linkUs = linkUsService.getByUuid("06586BF5AB834108BFFDCBEF4FE71A21");
		if(linkUs==null) {
			linkUs = new LinkUs();
			linkUs.setUuid(IdGenerator.generateId());
		}
		linkUs.setContent("联系我们呀哈哈");
		linkUs.setEditTime(new Date());
		
		Platform platform = platformService.getByOriginalId("luo_shengsha");
		linkUs.setPlatform(platform);
		
		linkUsService.edit(linkUs);
	}
	
	@Test
	public void getByPlatform() {
		Platform platform = platformService.getByOriginalId("luo_shengsha");
		LinkUs linkUs = linkUsService.getByPlatform(platform);
		System.out.println(linkUs.getUuid() + " " + linkUs.getContent() + " " + linkUs.getEditTime());
	}
	
	@Test
	public void getByUuid() {
		LinkUs linkUs = linkUsService.getByUuid("06586BF5AB834108BFFDCBEF4FE71A21");
		System.out.println(linkUs.getUuid() + " " + linkUs.getContent());
	}
}
