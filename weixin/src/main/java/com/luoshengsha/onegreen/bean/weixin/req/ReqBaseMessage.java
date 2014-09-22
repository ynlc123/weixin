package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的基础类
 * @author luoshengsha
 * @date 2014年9月3日 下午4:31:47
 */
public class ReqBaseMessage {
	/**开发者微信号**/
	private String ToUserName;
	/**发送方帐号（一个OpenID）**/
	private String FromUserName;
	/**消息创建时间 （整型）**/
	private long CreateTime;
	/**
	 * 消息类型
	 * text/image/voice/video/location/link
	 * **/
	private String MsgType;
	/**消息id，64位整型**/
	private String MsgId;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
