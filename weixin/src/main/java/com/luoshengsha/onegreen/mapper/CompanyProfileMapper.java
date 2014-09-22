package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.CompanyProfile;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 企业介绍mapper
 * @author luoshengsha
 * @date 2014年9月7日 下午10:33:03
 */
public interface CompanyProfileMapper {
	/**
	 * 保存企业介绍
	 * @param profile
	 */
	public void save(CompanyProfile profile);
	
	/**
	 * 更新企业介绍
	 * @param profile
	 */
	public void update(CompanyProfile profile);
	
	/**
	 * 根据平台获取企业介绍
	 * @param platform
	 * @return
	 */
	public CompanyProfile getByPlatform(Platform platform);
	
	/**
	 * 根据id获取企业介绍
	 * @param id
	 * @return
	 */
	public CompanyProfile find(Serializable id);
	
	/**
	 * 根据uuid获取企业介绍
	 * @param uuid
	 * @return
	 */
	public CompanyProfile getByUuid(String uuid);
	
	/**
	 * 保存简介的图片
	 * @param profile_id 简介id
	 * @param image_id 图片id
	 */
	public void saveProfileImages(@Param(value="profile_id") int profile_id,@Param(value="image_id") int image_id);
	
	/**
	 * 删除企业简介图片
	 * @param profile_id 简介id
	 */
	public void delProfileImages(int profile_id);
}
