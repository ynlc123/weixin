package com.luoshengsha.onegreen.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.CustomerMapper;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.utils.MD5Util;

/**
 * 客户接口实现
 * @author luoshengsha
 * @date 2014年9月4日 上午9:51:24
 */
@Service
public class CustomerServiceImpl extends DAOSupport<Customer> implements CustomerService {
	@Resource
	private CustomerMapper mapper;
	
	@Override
	protected BaseMapper<Customer> getMapper() {
		return mapper;
	}

	@Override
	public Customer getByAccount(String account) {
		return mapper.getByAccount(account);
	}

	@Override
	public boolean checkCustomer(String account, String password) {
		Customer customer = mapper.getByAccount(account);
		
		//客户不存在此账户，返回false
		if(customer==null) return false;
		
		//使用数据库中的用户uuid加密输入的密码
		String inputPassword = MD5Util.mixEncription(password, customer.getUuid());
		
		//判断加密后的输入密码是否与数据库中的密码一致？
		boolean flag = inputPassword.equals(customer.getPassword());
		
		return flag ? true : false;
	}

	@Override
	public void save(Customer customer) {
		/**加密用户密码开始**/
		String uuid = UUID.randomUUID().toString();
		String password = MD5Util.mixEncription(customer.getPassword(), uuid);
		
		customer.setPassword(password);
		customer.setUuid(uuid);
		
		super.save(customer);
	}

	@Override
	public void updatePwd(String password, Customer customer) {
		/**加密用户密码开始**/
		String uuid = UUID.randomUUID().toString();
		String new_password = MD5Util.mixEncription(password, uuid);
		
		customer.setPassword(new_password);//设置加密后的密码
		customer.setUuid(uuid);//保存生成的uuid
		/**加密用户密码结束**/
		
		mapper.updatePwd(new_password, uuid, customer);
	}

	@Override
	public void update(Customer customer) {
		mapper.update(customer);
	}

}
