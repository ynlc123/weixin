package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.SingleImageText;

/**
 * 单图文回复接口
 * @author luoshengsha
 * @date 2014年9月10日 上午11:40:07
 */
public interface SingleImageTextService extends BaseDAO<SingleImageText> {
	/**
	 * 根据关键词获取所有该平台下的单图文回复
	 * @param keywords 关键词
	 * @param platform 公众平台
	 * @return
	 */
	public SingleImageText getByKeywords(String keywords, Platform platform);
	
	/**
	 * 根据关键词获取该公众平台下指定状态的单图文回复
	 * @param keywords 关键词
	 * @param status 状态   1： 正常   0：禁用 -1：包括正常、禁用
	 * @param platform 公众平台
	 * @return
	 */
	public SingleImageText getByKeywords(String keywords, int status, Platform platform);
	
	/**
	 * 更新
	 * @param imageText
	 */
	public void update(SingleImageText imageText);
	
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
	 * 根据uuid获取自动回复文章
	 * @param uuid
	 * @return
	 */
	public SingleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除自动回复文章
	 * @param uuid
	 */
	public void delete(String uuid);
}
