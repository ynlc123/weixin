package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.ReplySingleImageText;

/**
 * 单图文回复接口
 * @author luoshengsha
 * @date 2014年9月10日 上午11:40:07
 */
public interface ReplySingleImageTextService extends BaseDAO<ReplySingleImageText> {
	/**
	 * 根据关键词获取自动回复文章
	 * @param keywords 关键词
	 * @return
	 */
	public ReplySingleImageText getByKeywords(String keywords);
	
	/**
	 * 更新
	 * @param imageText
	 */
	public void update(ReplySingleImageText imageText);
	
	/**
	 * 禁用
	 * @param imageText
	 */
	public void forbid(ReplySingleImageText imageText);
	
	/**
	 * 启用
	 * @param imageText
	 */
	public void enable(ReplySingleImageText imageText);
	
	/**
	 * 根据uuid获取自动回复文章
	 * @param uuid
	 * @return
	 */
	public ReplySingleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除自动回复文章
	 * @param uuid
	 */
	public void delete(String uuid);
}
