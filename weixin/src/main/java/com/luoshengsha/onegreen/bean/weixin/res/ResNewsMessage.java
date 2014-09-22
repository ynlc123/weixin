package com.luoshengsha.onegreen.bean.weixin.res;

import java.util.List;

/**
 * 回复图文消息
 * @author luoshengsha
 * @date 2014年9月3日 下午5:07:13
 */
public class ResNewsMessage extends ResBaseMessage {
	/**图文消息个数，限制为10条以内**/
	private int ArticleCount;
	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	 * **/
	private List<Item> Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Item> getArticles() {
		return Articles;
	}
	public void setArticles(List<Item> articles) {
		Articles = articles;
	}
}
