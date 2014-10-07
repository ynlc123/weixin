package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 单条图文回复
 * @author luoshengsha
 * @date 2014年9月3日 下午3:26:38
 */
public class SingleImageText {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**关键词**/
	private String keywords;
	/**标题**/
	private String title;
	/**图片**/
	private Image image;
	/**内容**/
	private String content;
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
