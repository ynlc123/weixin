package com.luoshengsha.onegreen.mapper;

import com.luoshengsha.onegreen.bean.DefaultReplyMessage;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 默认自动文本回复信息
 * @author luoshengsha
 * @date 2014年9月9日 下午10:25:44
 */
public interface DefaultReplyMessageMapper {
	/**
	 * 保存自动文本回复
	 * @param message
	 */
	public void save(DefaultReplyMessage message);
	
	/**
	 * 更新自动文本回复
	 * @param message
	 */
	public void update(DefaultReplyMessage message);
	
	/**
	 * 根据平台获取自动文本回复信息
	 * @param platform
	 * @return
	 */
	public DefaultReplyMessage getByPlatform(Platform platform);
}
