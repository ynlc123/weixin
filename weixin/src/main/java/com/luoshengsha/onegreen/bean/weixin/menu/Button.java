package com.luoshengsha.onegreen.bean.weixin.menu;

import com.luoshengsha.onegreen.bean.Platform;

/**
 * 按钮
 * @author luoshengsha
 * @date 2014年9月3日 下午4:19:53
 */
public class Button {
	/**id**/
	private int id;
	/**按钮名称**/
	private String name;
	/**公众号**/
	private Platform paltform;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Platform getPaltform() {
		return paltform;
	}
	public void setPaltform(Platform paltform) {
		this.paltform = paltform;
	}
}
