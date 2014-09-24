package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 微信公众号
 * @author luoshengsha
 * @date 2014年9月3日 下午3:00:50
 */
public class Platform {
	/**id**/
	private int id;
	/**公众平台uuid**/
	private String uuid;
	/**公众号原始id**/
	private String originalId;
	/**公众号**/
	private String platformNo;
	/**公众号登录用户名**/
	private String userName;
	/**公众号登录密码**/
	private String password;
	/**公众号appid**/
	private String appId;
	/**公众号appSecret**/
	private String appSecret;
	/**用户**/
	private Customer customer;
	/**开通时间**/
	private Date createTime;
	/**有效时间
	 * 特别说明：有效时间是针对此系统而言，不是对腾讯而言
	 **/
	private Date validTime;
	/**编辑时间**/
	private Date editTime;
	/**公众号类型  1-服务号 0-订阅号**/
	private int platformType;
	/**是否通过认证**/
	private boolean isAuth;
	
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
	public String getOriginalId() {
		return originalId;
	}
	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
	public String getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getValidTime() {
		return validTime;
	}
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public int getPlatformType() {
		return platformType;
	}
	public void setPlatformType(int platformType) {
		this.platformType = platformType;
	}
	public boolean isAuth() {
		return isAuth;
	}
	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Platform platform1 = new Platform();
		platform1.setUuid("111");
		
		Platform platform2 = new Platform();
		platform2.setUuid("111");
		
		System.out.println(platform1.equals(platform2));
	}
}
