package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.MutipleImageText;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.ArticleMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.MutipleImageTextMapper;
import com.luoshengsha.onegreen.service.MutipleImageTextService;

/**
 * 多图文回复接口实现
 * @author luoshengsha
 * @date 2014年9月29日 下午11:36:18
 */
@Service
public class MutipleImageTextServiceImpl extends
		DAOSupport<MutipleImageText> implements
		MutipleImageTextService {
	@Resource
	private MutipleImageTextMapper mapper;
	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	protected BaseMapper<MutipleImageText> getMapper() {
		return mapper;
	}

	@Override
	public MutipleImageText getByKeywords(String keyword, Platform platform) {
		return mapper.getByKeywords(keyword, -1, platform);
	}

	@Override
	public MutipleImageText getByKeywords(String keyword, int status,
			Platform platform) {
		return mapper.getByKeywords(keyword, status, platform);
	}

	@Override
	public void update(MutipleImageText imageText) {
		mapper.update(imageText);
		//删除自动回复文章关系
		mapper.delImageTextArticle(imageText);
		//更新自动回复文章信息
		mapper.update(imageText);
		//保存自动回复文章关系
		if(imageText.getArticles() != null && !imageText.getArticles().isEmpty()) {
			for(Article article : imageText.getArticles()) {
				mapper.saveImageTextArticle(imageText, article);
			}
		}
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
	public MutipleImageText getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(Serializable uuid) {
		MutipleImageText imageText = mapper.getByUuid(uuid);
		
		//删除自动回复与文章的关系
		mapper.delImageTextArticle(imageText);
		//删除自动回复
		mapper.delete(uuid);
	}

	@Override
	public void save(MutipleImageText imageText) {
		//保存自动回复文章信息
		super.save(imageText);
		//保存自动回复文章关系
		if(imageText.getArticles() != null && !imageText.getArticles().isEmpty()) {
			for(Article article : imageText.getArticles()) {
				mapper.saveImageTextArticle(imageText, article);
			}
		}
	}

}
