package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.DefaultMessage;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.DefaultMessageMapper;
import com.luoshengsha.onegreen.service.DefaultMessageService;

/**
 * 默认自动文本回复接口实现
 * @author luoshengsha
 * @date 2014年9月9日 下午10:30:05
 */
@Service
public class DefaultMessageServiceImpl implements
		DefaultMessageService {
	@Resource
	private DefaultMessageMapper mapper;
	
	@Override
	public void edit(DefaultMessage message) {
		if(getByPlatform(message.getPlatform()) == null) { //如果是第一次编辑，则保存信息
			mapper.save(message);
		} else { //否则，更新信息
			mapper.update(message);
		}
	}

	@Override
	public DefaultMessage getByPlatform(Platform platform) {
		return mapper.getByPlatform(platform);
	}

}
