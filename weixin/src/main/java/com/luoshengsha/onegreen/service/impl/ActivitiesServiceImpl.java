package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Activities;
import com.luoshengsha.onegreen.mapper.ActivitiesMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.ActivitiesService;

/**
 * 活动接口实现
 * @author luoshengsha
 * @date 2014年9月9日 下午11:09:07
 */
@Service
public class ActivitiesServiceImpl extends DAOSupport<Activities> implements
		ActivitiesService {
	@Resource
	private ActivitiesMapper mapper;
	
	@Override
	protected BaseMapper<Activities> getMapper() {
		return mapper;
	}

	@Override
	public void update(Activities activities) {
		mapper.update(activities);
	}

	@Override
	public Activities getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(String uuid) {
		mapper.delete(uuid);
	}

	@Override
	public void forbid(Serializable uuid) {
		mapper.forbid(uuid);
	}

	@Override
	public void enable(Serializable uuid) {
		mapper.enable(uuid);
	}

}
