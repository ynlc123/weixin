package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.User;

/**
 * 管理员接口
 * @author luoshengsha
 * @date 2014年9月3日 下午11:30:34
 */
public interface UserService extends BaseDAO<User> {
	/**
	 * 更新密码
	 * @param new_password 新密码
	 * @param user 用户
	 */
	public void updatePwd(String new_password, String hxKey, User user);
	
	/**
	 * 根据用户名获取用户
	 * @param name 用户名
	 * @return
	 */
	public User getUser(String account);
}
