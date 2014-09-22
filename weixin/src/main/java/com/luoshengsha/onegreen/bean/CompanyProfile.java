package com.luoshengsha.onegreen.bean;

import java.util.List;

/**
 * 公司简介
 * @author luoshengsha
 * @date 2014年9月3日 下午3:46:05
 */
public class CompanyProfile {
	/**id**/
	private int id;
	/**企业介绍uuid**/
	private String uuid;
	/**公司名称**/
	private String companyName;
	/**简介内容**/
	private String content;
	/**公司图片**/
	private List<Image> images;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
