package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Customer;

/**
 * 客户接口
 * @author luoshengsha
 * @date 2014年9月4日 上午9:44:14
 */
public interface CustomerService {
	/**
	 * 保存客户
	 * @param customer
	 */
	public void save(Customer customer);
	
	/**
	 * 查找客户
	 * @param id 客户id
	 * @return
	 */
	public Customer find(Serializable id);
	
	/**
	 * 更新客户
	 * @param customer 客户
	 */
	public void update(Customer customer);
	
	/**
	 * 根据账户获取客户
	 * @param account 登录账户名
	 * @return
	 */
	public Customer getByAccount(String account);
	
	/**
	 * 校验客户账户和密码
	 * @param account 账户
	 * @param password 密码
	 * @return
	 */
	public boolean checkCustomer(String account, String password);
	
	/**
	 * 更新密码
	 * @param password 新密码
	 * @param customer 客户
	 */
	public void updatePwd(String password, Customer customer);
}
