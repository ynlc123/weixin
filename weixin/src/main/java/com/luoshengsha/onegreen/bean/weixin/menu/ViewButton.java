package com.luoshengsha.onegreen.bean.weixin.menu;

/**
 * view按钮
 * @author luoshengsha
 * @date 2014年9月3日 下午4:23:05
 */
public class ViewButton extends Button {
	/**按钮类型**/
	private String type = "view";
	/**跳转url**/
	private String url;
	
	public String getType() {
		return type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
