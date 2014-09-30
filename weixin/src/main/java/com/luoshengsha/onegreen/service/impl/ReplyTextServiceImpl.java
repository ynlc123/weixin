package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.ReplyText;
import com.luoshengsha.onegreen.mapper.ReplyTextMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.ReplyTextService;

/**
 * 自动文本回复接口实现
 * @author luoshengsha
 * @date 2014年9月24日 下午4:05:31
 */
@Service
public class ReplyTextServiceImpl extends DAOSupport<ReplyText>
		implements ReplyTextService {
	@Resource
	private ReplyTextMapper mapper;

	@Override
	protected BaseMapper<ReplyText> getMapper() {
		return mapper;
	}
	
	@Override
	public ReplyText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void update(ReplyText autoReplyText) {
		mapper.update(autoReplyText);
	}

	@Override
	public void forbid(ReplyText autoReplyText) {
		mapper.setStatus(autoReplyText, 0);
	}

	@Override
	public void enable(ReplyText autoReplyText) {
		mapper.setStatus(autoReplyText, 1);
	}

	@Override
	public void delete(String uuid) {
		mapper.delete(uuid);
	}

}
