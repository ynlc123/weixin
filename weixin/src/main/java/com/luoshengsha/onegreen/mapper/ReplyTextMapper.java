package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.luoshengsha.onegreen.bean.Platform;
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
	public void setStatus(@Param(value="replyText") ReplyText replyText, @Param(value="status") int status);
	
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
	public ReplyText getByKeyword(@Param(value="keyword") String keyword, @Param(value="platform") Platform platform);
}
