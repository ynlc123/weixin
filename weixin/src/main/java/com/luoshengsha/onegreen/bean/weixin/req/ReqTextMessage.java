package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的文本消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:37:26
 */
public class ReqTextMessage extends ReqBaseMessage {
	/**文本内容**/
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
