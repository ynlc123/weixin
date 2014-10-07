package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.DefaultMessage;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 默认自动文本回复信息接口
 * @author luoshengsha
 * @date 2014年9月9日 下午10:31:27
 */
public interface DefaultMessageService {
	
	/**
	 * 编辑默认自动文本回复信息
	 * @param message
	 */
	public void edit(DefaultMessage message);
	
	/**
	 * 根据平台获取自动文本回复信息
	 * @param platform
	 * @return
	 */
	public DefaultMessage getByPlatform(Platform platform);
}
