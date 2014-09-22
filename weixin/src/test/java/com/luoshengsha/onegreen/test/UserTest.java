package com.luoshengsha.onegreen.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.User;
import com.luoshengsha.onegreen.service.UserService;

/**
 * 用户单元测试
 * @author luoshengsha
 * @date 2014年9月7日 下午10:59:10
 */
public class UserTest {
	protected static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			userService = (UserService)cxt.getBean("userServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void save() {
		User user = new User();
		
	}
}
