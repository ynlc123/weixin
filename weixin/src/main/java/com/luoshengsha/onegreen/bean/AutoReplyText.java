package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 自动回复文本信息
 * @author luoshengsha
 * @date 2014年9月24日 下午3:58:21
 */
public class AutoReplyText {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**关键词**/
	private String keywords;
	/**内容**/
	private String content;
	/**创建时间**/
	private Date createTime;
	/**编辑时间**/
	private Date editTime;
	/**状态 1：正常  0：禁用**/
	private int status;
	/**公众平台**/
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
