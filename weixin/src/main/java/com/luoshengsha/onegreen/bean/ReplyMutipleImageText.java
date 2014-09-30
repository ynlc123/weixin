package com.luoshengsha.onegreen.bean;

import java.util.Date;
import java.util.List;

/**
 * 多图文回复
 * @author luoshengsha
 * @date 2014年9月29日 下午11:27:54
 */
public class ReplyMutipleImageText {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**关键词**/
	private String keywords;
	/**文章集合**/
	private List<Article> articles;
	/**创建时间**/
	private Date createTime;
	/**编辑时间**/
	private Date editTime;
	/**是否有效，只有在有效状态才回复 1: 有效  0：无效**/
	private int status;
	/**公众号**/
	private Platform platform;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
