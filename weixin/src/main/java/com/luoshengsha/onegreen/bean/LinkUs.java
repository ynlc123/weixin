package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 联系我们
 * @author luoshengsha
 * @date 2014年9月3日 下午3:53:18
 */
public class LinkUs {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**内容**/
	private String content;
	/**编辑时间**/
	private Date editTime;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
}
