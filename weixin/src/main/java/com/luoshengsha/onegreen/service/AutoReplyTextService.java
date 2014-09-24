package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.AutoReplyText;

/**
 * 自动文本回复接口
 * @author luoshengsha
 * @date 2014年9月24日 下午4:04:33
 */
public interface AutoReplyTextService extends BaseDAO<AutoReplyText> {
	/***
	 * 根据uuid获取自动文本回复
	 * @param uuid
	 * @return
	 */
	public AutoReplyText getByUuid(String uuid);
	
	/**
	 * 更新
	 * @param autoReplyText
	 */
	public void update(AutoReplyText autoReplyText);
	
	/**
	 * 禁用
	 * @param autoReplyText
	 */
	public void forbid(AutoReplyText autoReplyText);
	
	/**
	 * 启用
	 * @param autoReplyText
	 */
	public void enable(AutoReplyText autoReplyText);
	
	/**
	 * 根据uuid删除自动文本回复
	 * @param uuid
	 */
	public void delete(String uuid);
}
