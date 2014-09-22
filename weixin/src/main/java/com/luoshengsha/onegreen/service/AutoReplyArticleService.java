package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.AutoReplyArticle;

/**
 * 自动回复接口
 * @author luoshengsha
 * @date 2014年9月10日 上午11:40:07
 */
public interface AutoReplyArticleService extends BaseDAO<AutoReplyArticle> {
	/**
	 * 根据关键词获取自动回复文章
	 * @param keywords 关键词
	 * @return
	 */
	public AutoReplyArticle getByKeywords(String keywords);
	
	/**
	 * 更新
	 * @param autoReplyArticle
	 */
	public void update(AutoReplyArticle autoReplyArticle);
	
	/**
	 * 禁用
	 * @param autoReplyArticle
	 */
	public void forbid(AutoReplyArticle autoReplyArticle);
	
	/**
	 * 启用
	 * @param autoReplyArticle
	 */
	public void enable(AutoReplyArticle autoReplyArticle);
	
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
