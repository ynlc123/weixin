package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 活动
 * @author luoshengsha
 * @date 2014年9月3日 下午3:55:44
 */
public class Activities {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**标题**/
	private String title;
	/**内容**/
	private String content;
	/**图片**/
	private Image image;
	/**创建时间**/
	private Date createTime;
	/**有效时长**/
	private int validDays;
	/**编辑时间**/
	private Date editTime;
	/**有效时间**/
	private Date validTime;
	/**公众号**/
	private Platform platform;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getValidDays() {
		return validDays;
	}
	public void setValidDays(int validDays) {
		this.validDays = validDays;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public Date getValidTime() {
		return validTime;
	}
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
