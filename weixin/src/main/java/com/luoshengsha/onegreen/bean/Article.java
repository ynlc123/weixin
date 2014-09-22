package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 文章
 * @author luoshengsha
 * @date 2014年9月3日 下午3:31:22
 */
public class Article {
	/**文章id**/
	private int id;
	/**系统生成的文章id**/
	private String uuid;
	/**文章标题（从自动回复中添加的文章没有标题）**/
	private String title;
	/**文章对应的图片(当文本文章时没有图片)**/
	private Image image;
	/**文章内容**/
	private String content;
	/**创建时间**/
	private Date createTime;
	/**编辑时间**/
	private Date editTime;
	/**公众号**/
	private Platform platform;
	/**文章类型**/
	private ArticleType type;
	/**是否是自动回复文章**/
	private boolean isAutoReply;
	/**浏览次数**/
	private int views;
	/**状态 1：可用   0：不可用**/
	private int status;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public ArticleType getType() {
		return type;
	}
	public void setType(ArticleType type) {
		this.type = type;
	}
	public boolean isAutoReply() {
		return isAutoReply;
	}
	public void setAutoReply(boolean isAutoReply) {
		this.isAutoReply = isAutoReply;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
