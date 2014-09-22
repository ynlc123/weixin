package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.DefaultReplyMessage;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.DefaultReplyMessageMapper;
import com.luoshengsha.onegreen.service.DefaultReplyMessageService;

/**
 * 默认自动文本回复接口实现
 * @author luoshengsha
 * @date 2014年9月9日 下午10:30:05
 */
@Service
public class DefaultReplyMessageServiceImpl implements
		DefaultReplyMessageService {
	@Resource
	private DefaultReplyMessageMapper mapper;
	
	@Override
	public void edit(DefaultReplyMessage message) {
		if(getByPlatform(message.getPlatform()) == null) { //如果是第一次编辑，则保存信息
			mapper.save(message);
		} else { //否则，更新信息
			mapper.update(message);
		}
	}

	@Override
	public DefaultReplyMessage getByPlatform(Platform platform) {
		return mapper.getByPlatform(platform);
	}

}
