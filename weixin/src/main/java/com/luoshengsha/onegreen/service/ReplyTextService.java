package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.ReplyText;

/**
 * 自动文本回复接口
 * @author luoshengsha
 * @date 2014年9月24日 下午4:04:33
 */
public interface ReplyTextService extends BaseDAO<ReplyText> {
	/***
	 * 根据uuid获取自动文本回复
	 * @param uuid
	 * @return
	 */
	public ReplyText getByUuid(String uuid);
	
	/**
	 * 更新
	 * @param autoReplyText
	 */
	public void update(ReplyText autoReplyText);
	
	/**
	 * 禁用
	 * @param autoReplyText
	 */
	public void forbid(ReplyText autoReplyText);
	
	/**
	 * 启用
	 * @param autoReplyText
	 */
	public void enable(ReplyText autoReplyText);
	
	/**
	 * 根据uuid删除自动文本回复
	 * @param uuid
	 */
	public void delete(String uuid);
	
	/**
	 * 根据关键词获取文本回复
	 * @param keyword 关键词
	 * @param platform 公众平台
	 * @return
	 */
	public ReplyText getByKeyword(String keyword, Platform platform);
}
