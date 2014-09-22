package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 客户
 * @author luoshengsha
 * @date 2014年9月3日 下午2:54:38
 */
public class Customer {
	/**id**/
	private int id;
	/**系统分配的客户id**/
	private String customerId;
	/**用户名**/
	private String name;
	/**密码**/
	private String password;
	/**姓名**/
	private String realName;
	/**手机**/
	private String mobile;
	/**座机**/
	private String phone;
	/**传真**/
	private String fax;
	/**邮箱**/
	private String email;
	/**创建时间**/
	private Date createTime;
	/**编辑时间**/
	private Date editTime;
	/**微信公众平台**/
	private Platform platform;
	/**uuid,与校验密码有关**/
	private String uuid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
