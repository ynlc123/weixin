package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * AccessToken
 * @author luoshengsha
 * @date 2014年9月4日 下午11:03:17
 */
public class AccessToken {
	/**access_token**/
	private String access_token;
	/**有效时间**/
	private int expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
