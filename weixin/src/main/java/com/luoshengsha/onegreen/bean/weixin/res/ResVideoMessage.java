package com.luoshengsha.onegreen.bean.weixin.res;

/**
 * 回复视频消息
 * @author luoshengsha
 * @date 2014年9月3日 下午5:03:13
 */
public class ResVideoMessage extends ResBaseMessage {
	/**通过上传多媒体文件，得到的id**/
	private String MediaId;
	/**视频消息的标题**/
	private String Title;
	/**视频消息的描述**/
	private String Description;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
