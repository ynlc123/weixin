package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.ReplySingleImageText;

/**
 * 自动回复mapper
 * @author luoshengsha
 * @date 2014年9月10日 上午11:36:36
 */
public interface AutoReplyArticleMapper extends BaseMapper<ReplySingleImageText> {
	/**
	 * 保存自动回复与文章的关系
	 * @param replyArticle 自动回复文章
	 * @param article 文章
	 */
	public void saveAutoReplyArticle(@Param(value="replyArticle") ReplySingleImageText replyArticle, @Param(value="article") Article article);
	
	/**
	 * 删除自动回复与文章的关系
	 * @param replyArticle 自动回复文章
	 */
	public void delAutoReplyArticle(ReplySingleImageText replyArticle);
	
	/**
	 * 根据关键词获取自动回复文章
	 * @param keywords 关键词
	 * @return
	 */
	public ReplySingleImageText getByKeywords(String keywords);
	
	/**
	 * 设置自动回复文章状态
	 * @param autoReplyArticle
	 * @param isValid
	 */
	public void setStatus(@Param(value="autoReplyArticle") ReplySingleImageText autoReplyArticle, @Param(value="isValid") boolean isValid);

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
