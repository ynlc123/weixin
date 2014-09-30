package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.ReplyText;

/**
 * 自动文本回复mapper
 * @author luoshengsha
 * @date 2014年9月24日 下午4:02:34
 */
public interface ReplyTextMapper extends BaseMapper<ReplyText> {
	/***
	 * 根据uuid获取自动文本回复
	 * @param uuid
	 * @return
	 */
	public ReplyText getByUuid(String uuid);
	
	/**
	 * 设置自动文本回复状态
	 * @param autoReplyText
	 * @param status
	 */
	public void setStatus(@Param(value="autoReplyText") ReplyText autoReplyText, @Param(value="status") int status);
	
	/**
	 * 根据uuid删除自动文本回复
	 * @param uuid
	 */
	public void delete(String uuid);

}
