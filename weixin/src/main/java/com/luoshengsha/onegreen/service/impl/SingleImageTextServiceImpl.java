package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.SingleImageText;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.SingleImageTextMapper;
import com.luoshengsha.onegreen.service.SingleImageTextService;

/**
 * 单图文回复接口实现
 * @author luoshengsha
 * @date 2014年9月10日 上午11:41:18
 */
@Service
public class SingleImageTextServiceImpl extends DAOSupport<SingleImageText>
		implements SingleImageTextService {
	@Resource
	private SingleImageTextMapper mapper;

	@Override
	protected BaseMapper<SingleImageText> getMapper() {
		return mapper;
	}

	@Override
	public SingleImageText getByKeywords(String keywords, Platform platform) {
		return mapper.getByKeywords(keywords, -1, platform);
	}

	@Override
	public SingleImageText getByKeywords(String keywords, int status,
			Platform platform) {
		return mapper.getByKeywords(keywords, status, platform);
	}

	@Override
	public void update(SingleImageText imageText) {
		mapper.update(imageText);
	}

	@Override
	public void forbid(Serializable uuid) {
		mapper.setStatus(uuid, 0);
	}

	@Override
	public void enable(Serializable uuid) {
		mapper.setStatus(uuid, 1);
	}

	@Override
	public SingleImageText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(String uuid) {
		mapper.delete(uuid);
	}
}
