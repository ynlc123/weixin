package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 图片
 * @author luoshengsha
 * @date 2014年9月3日 下午3:51:48
 */
public class Image {
	/**id**/
	private int id;
	/**uuid**/
	private String uuid;
	/**标题**/
	private String title;
	/**图片路径**/
	private String path;
	/**创建时间**/
	private Date createTime;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
