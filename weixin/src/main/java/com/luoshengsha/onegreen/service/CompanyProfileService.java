package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.CompanyProfile;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 企业介绍接口
 * @author luoshengsha
 * @date 2014年9月7日 下午10:38:25
 */
public interface CompanyProfileService {
	/**
	 * 编辑企业介绍
	 * @param profile
	 */
	public void edit(CompanyProfile profile);
	
	/**
	 * 根据id获取企业介绍
	 * @param id
	 * @return
	 */
	public CompanyProfile find(Serializable id);
	
	/**
	 * 根据平台获取企业介绍
	 * @param platform
	 * @return
	 */
	public CompanyProfile getByPlatform(Platform platform);
	
	/**
	 * 根据uuid获取企业介绍
	 * @param uuid
	 * @return
	 */
	public CompanyProfile getByUuid(String uuid);
}
