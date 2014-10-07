package com.luoshengsha.onegreen.mapper;

import com.luoshengsha.onegreen.bean.DefaultMessage;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 默认自动文本回复信息
 * @author luoshengsha
 * @date 2014年9月9日 下午10:25:44
 */
public interface DefaultMessageMapper {
	/**
	 * 保存自动文本回复
	 * @param message
	 */
	public void save(DefaultMessage message);
	
	/**
	 * 更新自动文本回复
	 * @param message
	 */
	public void update(DefaultMessage message);
	
	/**
	 * 根据平台获取自动文本回复信息
	 * @param platform
	 * @return
	 */
	public DefaultMessage getByPlatform(Platform platform);
}
