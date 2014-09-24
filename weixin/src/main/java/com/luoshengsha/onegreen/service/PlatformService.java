package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 公众平台
 * @author luoshengsha
 * @date 2014年9月4日 上午11:41:15
 */
public interface PlatformService {
	/**
	 * 编辑公众号
	 * @param platform
	 */
	public void edit(Platform platform);
	
	/**
	 * 获取客户的公众号
	 * @param customer 客户
	 * @return
	 */
	public Platform getByCustomer(Customer customer);
	
	/**
	 * 根据公众号获取
	 * @param originalId 公众号原始id
	 * @return
	 */
	public Platform getByOriginalId(String originalId);
	
	/**
	 * 根据appid获取公众号信息
	 * @param appId 公众号appid
	 * @return
	 */
	public Platform getByAppID(String appId);
}
