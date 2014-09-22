package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Customer;

/**
 * 客户mapper
 * @author luoshengsha
 * @date 2014年9月4日 上午9:36:31
 */
public interface CustomerMapper extends BaseMapper<Customer> {
	/**
	 * 根据账户获取客户
	 * @param account 登录账户名
	 * @return
	 */
	public Customer getByAccount(String account);
	
	/**
	 * 更新密码
	 * @param new_password 新密码
	 * @param uuid 客户uuid
	 * @param customer 客户
	 */
	public void updatePwd(@Param(value="new_password")String new_password, @Param(value="uuid")String uuid, @Param(value="customer")Customer customer);

}
