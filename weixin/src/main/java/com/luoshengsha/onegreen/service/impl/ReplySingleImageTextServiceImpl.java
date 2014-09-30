package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.ReplySingleImageText;
import com.luoshengsha.onegreen.mapper.ReplySingleImageTextMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.ReplySingleImageTextService;

/**
 * 单图文回复接口实现
 * @author luoshengsha
 * @date 2014年9月10日 上午11:41:18
 */
@Service
public class ReplySingleImageTextServiceImpl extends DAOSupport<ReplySingleImageText>
		implements ReplySingleImageTextService {
	@Resource
	private ReplySingleImageTextMapper mapper;

	@Override
	protected BaseMapper<ReplySingleImageText> getMapper() {
		return mapper;
	}

	@Override
	public ReplySingleImageText getByKeywords(String keywords) {
		return mapper.getByKeywords(keywords);
	}

	@Override
	public void update(ReplySingleImageText imageText) {
		mapper.update(imageText);
	}

	@Override
	public void forbid(ReplySingleImageText imageText) {
		mapper.setStatus(imageText, 0);
	}

	@Override
	public void enable(ReplySingleImageText imageText) {
		mapper.setStatus(imageText, 1);
	}

	@Override
	public ReplySingleImageText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(String uuid) {
		mapper.delete(uuid);
	}
}
