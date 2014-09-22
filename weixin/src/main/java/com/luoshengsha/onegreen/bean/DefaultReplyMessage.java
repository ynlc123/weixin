package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 默认文本回复信息
 * @author luoshengsha
 * @date 2014年9月3日 下午3:41:57
 */
public class DefaultReplyMessage {
	/**id**/
	private int id;
	/**回复内容**/
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
