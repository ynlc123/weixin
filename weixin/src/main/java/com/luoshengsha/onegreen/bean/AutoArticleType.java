package com.luoshengsha.onegreen.bean;

/**
 * 图文回复文章类型
 * @author luoshengsha
 * @date 2014年9月3日 下午3:39:26
 */
public enum AutoArticleType {
	SINGLE("单图文"),MUTIPLE("多图文");
	
	private String name;
	
	AutoArticleType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
