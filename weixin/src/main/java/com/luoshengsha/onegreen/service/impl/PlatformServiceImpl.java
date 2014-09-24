package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.PlatformMapper;
import com.luoshengsha.onegreen.service.PlatformService;

/**
 * 公众号接口实现
 * @author luoshengsha
 * @date 2014年9月4日 下午2:23:51
 */
@Service
public class PlatformServiceImpl implements PlatformService {
	@Resource
	private PlatformMapper mapper;
	
	@Override
	public void edit(Platform platform) {
		if(mapper.getByUuid(platform.getUuid())==null) {//第一次添加公众号信息
			//保存
			mapper.save(platform);
		} else {
			//更新
			mapper.update(platform);
		}
	}

	@Override
	public Platform getByCustomer(Customer customer) {
		return mapper.getByCustomer(customer);
	}

	@Override
	public Platform getByOriginalId(String originalId) {
		return mapper.getByOriginalId(originalId);
	}

	@Override
	public Platform getByAppID(String appId) {
		return mapper.getByAppID(appId);
	}

}
