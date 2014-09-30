package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.ReplyMutipleImageText;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.ReplyMutipleImageTextMapper;
import com.luoshengsha.onegreen.service.ReplyMutipleImageTextService;

/**
 * 多图文回复接口实现
 * @author luoshengsha
 * @date 2014年9月29日 下午11:36:18
 */
@Service
public class ReplyMutipleImageTextServiceImpl extends
		DAOSupport<ReplyMutipleImageText> implements
		ReplyMutipleImageTextService {
	@Resource
	private ReplyMutipleImageTextMapper mapper;
	
	@Override
	protected BaseMapper<ReplyMutipleImageText> getMapper() {
		return mapper;
	}

	@Override
	public ReplyMutipleImageText getByKeywords(String keywords) {
		return mapper.getByKeywords(keywords);
	}

	@Override
	public void update(ReplyMutipleImageText imageText) {
		mapper.update(imageText);
	}

	@Override
	public void forbid(ReplyMutipleImageText imageText) {
		mapper.setStatus(imageText, 0);
	}

	@Override
	public void enable(ReplyMutipleImageText imageText) {
		mapper.setStatus(imageText, 1);
	}

	@Override
	public ReplyMutipleImageText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(Serializable uuid) {
		mapper.delete(uuid);
	}

}
