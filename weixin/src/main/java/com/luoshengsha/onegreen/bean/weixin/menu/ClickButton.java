package com.luoshengsha.onegreen.bean.weixin.menu;

/**
 * 点击按钮
 * @author luoshengsha
 * @date 2014年9月3日 下午4:25:58
 */
public class ClickButton extends Button {
	/**按钮类型**/
	private String type = "click";
	/**按钮key**/
	private String key;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
}
