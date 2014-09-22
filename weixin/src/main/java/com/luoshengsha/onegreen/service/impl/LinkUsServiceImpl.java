package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.LinkUs;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.LinkUsMapper;
import com.luoshengsha.onegreen.service.LinkUsService;

/**
 * 关于我们接口实现
 * @author luoshengsha
 * @date 2014年9月7日 下午10:01:00
 */
@Service
public class LinkUsServiceImpl implements LinkUsService {
	@Resource
	private LinkUsMapper mapper;
	
	@Override
	public void edit(LinkUs linkUs) {
		if(getByUuid(linkUs.getUuid())==null) {//第一次保存
			mapper.save(linkUs);
		} else {
			mapper.update(linkUs);
		}
	}

	@Override
	public LinkUs getByPlatform(Platform platform) {
		return mapper.getByPlatform(platform);
	}

	@Override
	public LinkUs getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

}
