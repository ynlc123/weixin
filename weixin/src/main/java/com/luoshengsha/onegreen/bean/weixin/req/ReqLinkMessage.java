package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的链接消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:51:34
 */
public class ReqLinkMessage extends ReqBaseMessage {
	/**消息标题**/
	private String Title;
	/**消息描述**/
	private String Description;
	/**消息链接**/
	private String Url;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
