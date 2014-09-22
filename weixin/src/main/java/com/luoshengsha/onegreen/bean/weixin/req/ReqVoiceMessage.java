package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的语音消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:43:09
 */
public class ReqVoiceMessage extends ReqBaseMessage {
	/**语音消息媒体id，可以调用多媒体文件下载接口拉取数据**/
	private String MediaId;
	/**语音格式，如amr，speex等**/
	private String Format;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
}
