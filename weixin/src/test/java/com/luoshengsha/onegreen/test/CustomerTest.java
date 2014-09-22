package com.luoshengsha.onegreen.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.utils.IdGenerator;

/**
 * 客户单元测试
 * @author luoshengsha
 * @date 2014年9月7日 下午11:04:09
 */
public class CustomerTest {
	protected static CustomerService customerService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			customerService = (CustomerService)cxt.getBean("customerServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存客户
	 */
	@Test
	public void save() {
		Customer customer = new Customer();
		customer.setCustomerId(IdGenerator.generateId());
		customer.setName("luoshengsha");
		customer.setPassword("123456");
		customer.setRealName("罗生沙");
		customer.setMobile("13919860400");
		customer.setPhone("0931-7635206");
		customer.setFax("0931-7635206");
		customer.setEmail("ynlc123@163.com");
		customer.setCreateTime(new Date());
		
		customerService.save(customer);
	}
	
	@Test
	public void find() {
		Customer customer = customerService.find(1);
		System.out.println(customer.getName() + " " + customer.getPassword() + " " + customer.getCustomerId());
	}
	
	@Test
	public void update() {
		Customer customer = customerService.find(1);
		customer.setEmail("luoshengsha@163.com");
		customerService.update(customer);
	}
	
	@Test
	public void getByAccount() {
		Customer customer = customerService.getByAccount("luoshengsha");
		System.out.println(customer.getRealName() + " " + customer.getEmail());
	}
	
	@Test
	public void checkCustomer() {
		boolean flag = customerService.checkCustomer("luoshengsha", "654321");
		System.out.println("flag: " + flag);
	}
	
	@Test
	public void updatePwd() {
		Customer customer = customerService.getByAccount("luoshengsha");
		customerService.updatePwd("654321", customer);
	}
}
