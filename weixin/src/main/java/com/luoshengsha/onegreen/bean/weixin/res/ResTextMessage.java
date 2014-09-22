package com.luoshengsha.onegreen.bean.weixin.res;

/**
 * 回复文本消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:59:00
 */
public class ResTextMessage extends ResBaseMessage {
	/**文本内容**/
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
