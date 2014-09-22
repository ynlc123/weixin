package com.luoshengsha.onegreen.bean;

import java.util.Date;

/**
 * 粉丝
 * @author luoshengsha
 * @date 2014年9月3日 下午3:13:02
 */
public class Fans {
	/**id**/
	private int id;
	/**用户是否订阅该公众号标识
	 * 0：代表此用户没有关注该公众号，拉取不到其余信息
	 * 1：代表已关注
	 **/
	private int subscribe;
	/**粉丝openId**/
	private String openid;
	/**粉丝昵称**/
	private String nickname;
	/**
	 * 粉丝性别
	 * 1：男性
	 * 2：女性
	 * 0：未知
	 **/
	private int sex;
	/**
	 * 用户的语言，简体中文为zh_CN
	 */
	private String language;
	/**用户所在城市**/
	private String city;
	/**用户所在省份**/
	private String province;
	/**用户所在国家**/
	private String country;
	/**用户头像地址**/
	private String headimgurl;
	/**用户关注时间**/
	private Date subscribe_time;
	/**用户取消关注时间**/
	private Date unsubscribe_time;
	/**用户unionid，具体含义见微信公众号文档**/
	private String unionid;
	/**签到总积分**/
	private int signScore;
	/**最后一次签到时间**/
	private Date lastestSignTime;
	/**公众平台**/
	private Platform platform;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Date getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public Date getUnsubscribe_time() {
		return unsubscribe_time;
	}
	public void setUnsubscribe_time(Date unsubscribe_time) {
		this.unsubscribe_time = unsubscribe_time;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public int getSignScore() {
		return signScore;
	}
	public void setSignScore(int signScore) {
		this.signScore = signScore;
	}
	public Date getLastestSignTime() {
		return lastestSignTime;
	}
	public void setLastestSignTime(Date lastestSignTime) {
		this.lastestSignTime = lastestSignTime;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
}
