package com.luoshengsha.onegreen.mapper;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 公众平台mapper
 * @author luoshengsha
 * @date 2014年9月4日 下午2:14:47
 */
public interface PlatformMapper {
	/**
	 * 保存
	 * @param platform
	 */
	public void save(Platform platform);
	
	/**
	 * 更新
	 * @param platform
	 */
	public void update(Platform platform);
	
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
	 * 根据uuid获取公众平台
	 * @param uuid
	 * @return
	 */
	public Platform getByUuid(String uuid);

	/**
	 * 根据appid获取公众号
	 * @param appId
	 * @return
	 */
	public Platform getByAppID(String appId);
}
