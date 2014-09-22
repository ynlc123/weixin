package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.Article;

/**
 * 文章接口
 * @author luoshengsha
 * @date 2014年9月10日 上午10:27:06
 */
public interface ArticleService extends BaseDAO<Article> {
	/**
	 * 更新文章
	 * @param article
	 */
	public void update(Article article);
	
	/**
	 * 根据uuid获取文章
	 * @param uuid
	 */
	public Article getByUuid(String uuid);
	
	/**
	 * 增加浏览次数
	 * @param uuid 文章的uuid
	 */
	public void increaseViews(String uuid);
	
	/**
	 * 禁用文章（假删除）
	 * @param uuid
	 */
	public void forbid(String uuid);
}
