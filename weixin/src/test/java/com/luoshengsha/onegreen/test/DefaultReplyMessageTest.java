package com.luoshengsha.onegreen.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.DefaultReplyMessage;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.DefaultReplyMessageService;
import com.luoshengsha.onegreen.service.PlatformService;

/**
 * 默认自动文本回复信息
 * @author luoshengsha
 * @date 2014年9月9日 下午10:43:16
 */
public class DefaultReplyMessageTest {
	protected static PlatformService platformService;
	protected static DefaultReplyMessageService defaultReplyMessageService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			defaultReplyMessageService = (DefaultReplyMessageService)cxt.getBean("defaultReplyMessageServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑
	 */
	@Test
	public void edit() {
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		DefaultReplyMessage message = defaultReplyMessageService.getByPlatform(platform);
		if(message == null) {
			message = new DefaultReplyMessage();
		}
		message.setContent("这是默认自动文本回复信息！哈哈哈哈哈哈");
		message.setEditTime(new Date());
		message.setPlatform(platform);
		
		defaultReplyMessageService.edit(message);
	}
	
	/**
	 * 根据平台获取
	 */
	@Test
	public void getByPlatform() {
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		DefaultReplyMessage message = defaultReplyMessageService.getByPlatform(platform);
		System.out.println(message.getContent() + "  " + message.getEditTime());
	}
}
