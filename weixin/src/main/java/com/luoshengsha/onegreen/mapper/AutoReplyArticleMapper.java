package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.AutoReplyArticle;

/**
 * 自动回复mapper
 * @author luoshengsha
 * @date 2014年9月10日 上午11:36:36
 */
public interface AutoReplyArticleMapper extends BaseMapper<AutoReplyArticle> {
	/**
	 * 保存自动回复与文章的关系
	 * @param replyArticle 自动回复文章
	 * @param article 文章
	 */
	public void saveAutoReplyArticle(AutoReplyArticle replyArticle, Article article);
	
	/**
	 * 删除自动回复与文章的关系
	 * @param replyArticle 自动回复文章
	 */
	public void delAutoReplyArticle(AutoReplyArticle replyArticle);
	
	/**
	 * 根据关键词获取自动回复文章
	 * @param keywords 关键词
	 * @return
	 */
	public AutoReplyArticle getByKeywords(String keywords);
	
	/**
	 * 设置自动回复文章状态
	 * @param autoReplyArticle
	 * @param isValid
	 */
	public void setStatus(@Param(value="autoReplyArticle") AutoReplyArticle autoReplyArticle, boolean isValid);

	/**
	 * 根据uuid获取自动回复文章
	 * @param uuid
	 * @return
	 */
	public AutoReplyArticle getByUuid(String uuid);
	
	/**
	 * 根据uuid删除自动回复文章
	 * @param uuid
	 */
	public void delete(String uuid);
}
