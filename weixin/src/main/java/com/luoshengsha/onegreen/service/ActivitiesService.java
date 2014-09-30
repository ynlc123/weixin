package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Activities;

/**
 * 活动接口
 * @author luoshengsha
 * @date 2014年9月9日 下午11:08:14
 */
public interface ActivitiesService extends BaseDAO<Activities> {
	/**
	 * 更新活动
	 * @param activities
	 */
	public void update(Activities activities);
	
	/**
	 * 根据uuid获取活动
	 * @param uuid 活动uuid
	 * @return
	 */
	public Activities getByUuid(String uuid);
	
	/**
	 * 根据uuid删除活动
	 * @param uuid
	 */
	public void delete(String uuid);
	
	/**
	 * 根据uuid禁用活动
	 * @param uuid
	 */
	public void forbid(Serializable uuid);
	
	/**
	 * 根据uuid启用活动
	 * @param uuid
	 */
	public void enable(Serializable uuid);
}
