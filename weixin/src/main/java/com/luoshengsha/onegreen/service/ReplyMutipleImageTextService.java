package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.ReplyMutipleImageText;

/**
 * 多图文回复接口
 * @author luoshengsha
 * @date 2014年9月29日 下午11:34:48
 */
public interface ReplyMutipleImageTextService extends
		BaseDAO<ReplyMutipleImageText> {
	/**
	 * 根据关键词获取多图文回复
	 * @param keywords 关键词
	 * @return
	 */
	public ReplyMutipleImageText getByKeywords(String keywords);
	
	/**
	 * 更新
	 * @param imageText
	 */
	public void update(ReplyMutipleImageText imageText);
	
	/**
	 * 禁用
	 * @param imageText
	 */
	public void forbid(ReplyMutipleImageText imageText);
	
	/**
	 * 启用
	 * @param imageText
	 */
	public void enable(ReplyMutipleImageText imageText);
	
	/**
	 * 根据uuid获取多图文回复
	 * @param uuid
	 * @return
	 */
	public ReplyMutipleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除多图文回复
	 * @param uuid
	 */
	public void delete(Serializable uuid);
}
