package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.AutoReplyText;
import com.luoshengsha.onegreen.mapper.AutoReplyTextMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.AutoReplyTextService;

/**
 * 自动文本回复接口实现
 * @author luoshengsha
 * @date 2014年9月24日 下午4:05:31
 */
@Service
public class AutoReplyTextServiceImpl extends DAOSupport<AutoReplyText>
		implements AutoReplyTextService {
	@Resource
	private AutoReplyTextMapper mapper;

	@Override
	protected BaseMapper<AutoReplyText> getMapper() {
		return mapper;
	}
	
	@Override
	public AutoReplyText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void update(AutoReplyText autoReplyText) {
		mapper.update(autoReplyText);
	}

	@Override
	public void forbid(AutoReplyText autoReplyText) {
		mapper.setStatus(autoReplyText, 0);
	}

	@Override
	public void enable(AutoReplyText autoReplyText) {
		mapper.setStatus(autoReplyText, 1);
	}

	@Override
	public void delete(String uuid) {
		mapper.delete(uuid);
	}

}
