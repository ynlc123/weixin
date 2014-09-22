package com.luoshengsha.onegreen.bean.weixin.res;

/**
 * 回复语音消息
 * @author luoshengsha
 * @date 2014年9月3日 下午5:01:45
 */
public class ResVoiceMessage extends ResBaseMessage {
	/**通过上传多媒体文件，得到的id**/
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
