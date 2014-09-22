package com.luoshengsha.onegreen.bean;

/**
 * 文章类型
 * @author luoshengsha
 * @date 2014年9月3日 下午3:39:26
 */
public enum ArticleType {
	TEXT("文本文章"),IMAGE_TEXT("图文文章");
	
	private String name;
	
	ArticleType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
