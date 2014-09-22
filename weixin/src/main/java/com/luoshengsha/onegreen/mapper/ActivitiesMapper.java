package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Activities;

/**
 * 活动mapper
 * @author luoshengsha
 * @date 2014年9月9日 下午10:54:28
 */
public interface ActivitiesMapper extends BaseMapper<Activities> {
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
	public void delete(Serializable uuid);
	
	/**
	 * 根据uuid禁用活动（假删除）
	 * @param uuid
	 */
	public void forbid(Serializable uuid);
}
