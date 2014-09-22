package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 来自微信的地理位置消息
 * @author luoshengsha
 * @date 2014年9月3日 下午4:48:24
 */
public class ReqLocationMessage extends ReqBaseMessage {
	/**地理位置维度**/
	private String Location_X;
	/**地理位置经度**/
	private String Location_Y;
	/**地图缩放大小**/
	private int Scale;
	/**地理位置信息**/
	private String Label;
	
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public int getScale() {
		return Scale;
	}
	public void setScale(int scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
}
