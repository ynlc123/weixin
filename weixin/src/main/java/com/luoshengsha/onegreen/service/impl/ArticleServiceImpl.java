package com.luoshengsha.onegreen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.mapper.ArticleMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.ArticleService;

/**
 * 文章接口实现
 * @author luoshengsha
 * @date 2014年9月10日 上午10:28:24
 */
@Service
public class ArticleServiceImpl extends DAOSupport<Article> implements
		ArticleService {
	@Resource
	private ArticleMapper mapper;
	
	@Override
	protected BaseMapper<Article> getMapper() {
		return mapper;
	}
	
	@Override
	public void update(Article article) {
		mapper.update(article);
	}

	@Override
	public Article getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void increaseViews(String uuid) {
		mapper.increaseViews(uuid);
	}

	@Override
	public void forbid(String uuid) {
		mapper.forbid(uuid);
	}
}
