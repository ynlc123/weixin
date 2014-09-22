package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.User;

/**
 * 管理员mapper
 * @author luoshengsha
 * @date 2014年9月3日 下午11:21:32
 */
public interface UserMapper extends BaseMapper<User> {
	/**
	 * 更新密码
	 * @param new_password 新密码
	 * @param user 用户
	 */
	public void updatePwd(@Param(value="new_password")String new_password, @Param(value="hxKey")String hxKey, @Param(value="user")User user);
	
	/**
	 * 根据用户名获取用户
	 * @param name 用户名
	 * @return
	 */
	public User getUser(@Param(value="account")String account);
}
