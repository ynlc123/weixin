package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.MutipleImageText;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 多图文回复接口
 * @author luoshengsha
 * @date 2014年9月29日 下午11:34:48
 */
public interface MutipleImageTextService extends
		BaseDAO<MutipleImageText> {
	/**
	 * 根据关键词获取多图文回复
	 * @param keyword 关键词
	 * @param platform 公众平台
	 * @return
	 */
	public MutipleImageText getByKeywords(String keyword, Platform platform);
	
	/**
	 * 根据关键词获取多图文回复
	 * @param keyword 关键词
	 * @param status  状态   1： 正常   0：禁用 -1：包括正常、禁用
	 * @param platform 公众平台
	 * @return
	 */
	public MutipleImageText getByKeywords(String keyword, int status, Platform platform);
	
	/**
	 * 更新
	 * @param imageText
	 */
	public void update(MutipleImageText imageText);
	
	/**
	 * 禁用
	 * @param uuid
	 */
	public void forbid(Serializable uuid);
	
	/**
	 * 启用
	 * @param uuid
	 */
	public void enable(Serializable uuid);
	
	/**
	 * 根据uuid获取多图文回复
	 * @param uuid
	 * @return
	 */
	public MutipleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除多图文回复
	 * @param uuid
	 */
	public void delete(Serializable uuid);
}
