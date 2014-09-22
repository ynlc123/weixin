package com.luoshengsha.onegreen.mapper;

import com.luoshengsha.onegreen.bean.Article;

/**
 * 文章mapper
 * @author luoshengsha
 * @date 2014年9月10日 上午10:24:51
 */
public interface ArticleMapper extends BaseMapper<Article> {
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
