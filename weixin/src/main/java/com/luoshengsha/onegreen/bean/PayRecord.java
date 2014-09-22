package com.luoshengsha.onegreen.bean;

/**
 * 充值记录
 * @author luoshengsha
 * @date 2014年9月4日 上午11:31:09
 */
public class PayRecord {
	/**id**/
	private int id;
	/**订单号**/
	private String orderNo;
	/**消费内容**/
	private String content;
	/**价格**/
	private double price;
	/**公众平台**/
	private Platform platform;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
