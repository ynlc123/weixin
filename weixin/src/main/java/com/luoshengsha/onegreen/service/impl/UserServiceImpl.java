package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.User;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.UserMapper;
import com.luoshengsha.onegreen.service.UserService;

/**
 * 管理员接口实现
 * @author luoshengsha
 * @date 2014年9月3日 下午11:35:30
 */
@Service
public class UserServiceImpl extends DAOSupport<User> implements UserService {
	@Resource
	private UserMapper mapper;
	
	@Override
	protected BaseMapper<User> getMapper() {
		return mapper;
	}
	
	@Override
	public void updatePwd(String new_password, String hxKey, User user) {
		mapper.updatePwd(new_password, hxKey, user);
	}

	@Override
	public User getUser(String account) {
		return mapper.getUser(account);
	}

}
