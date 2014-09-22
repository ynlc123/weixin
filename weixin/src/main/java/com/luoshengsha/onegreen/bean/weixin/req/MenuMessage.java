package com.luoshengsha.onegreen.bean.weixin.req;

/**
 * 创建菜单返回信息
 * @author luoshengsha
 * @date 2014年9月4日 下午11:03:04
 */
public class MenuMessage {
	/**错误代码 0：执行成功**/
	private int errcode;
	/**错误消息 ok：创建成功**/
	
	private String errmsg;
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
