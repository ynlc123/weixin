package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的图片消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:39:39
 */
public class ReqImageMessage extends ReqBaseMessage {
	/**图片链接**/
	private String PicUrl;
	/**图片消息媒体id，可以调用多媒体文件下载接口拉取数据**/
	private String MediaId;
	
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
