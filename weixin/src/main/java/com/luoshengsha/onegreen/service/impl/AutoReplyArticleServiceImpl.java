package com.luoshengsha.onegreen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.AutoReplyArticle;
import com.luoshengsha.onegreen.mapper.ArticleMapper;
import com.luoshengsha.onegreen.mapper.AutoReplyArticleMapper;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.service.AutoReplyArticleService;

/**
 * 自动回复接口实现
 * @author luoshengsha
 * @date 2014年9月10日 上午11:41:18
 */
@Service
public class AutoReplyArticleServiceImpl extends DAOSupport<AutoReplyArticle>
		implements AutoReplyArticleService {
	@Resource
	private AutoReplyArticleMapper mapper;
	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	protected BaseMapper<AutoReplyArticle> getMapper() {
		return mapper;
	}

	@Override
	public AutoReplyArticle getByKeywords(String keywords) {
		return mapper.getByKeywords(keywords);
	}

	@Override
	public void save(AutoReplyArticle autoReplyArticle) {
		//保存自动回复文章信息
		super.save(autoReplyArticle);
		//保存自动回复文章关系
		if(autoReplyArticle.getArticles() != null && !autoReplyArticle.getArticles().isEmpty()) {
			for(Article article : autoReplyArticle.getArticles()) {
				mapper.saveAutoReplyArticle(autoReplyArticle, article);
			}
		}
	}

	@Override
	public void update(AutoReplyArticle autoReplyArticle) {
		//删除自动回复文章关系
		mapper.delAutoReplyArticle(autoReplyArticle);
		//更新自动回复文章信息
		mapper.update(autoReplyArticle);
		//保存自动回复文章关系
		if(autoReplyArticle.getArticles() != null && !autoReplyArticle.getArticles().isEmpty()) {
			for(Article article : autoReplyArticle.getArticles()) {
				mapper.saveAutoReplyArticle(autoReplyArticle, article);
			}
		}
	}

	@Override
	public void forbid(AutoReplyArticle autoReplyArticle) {
		mapper.setStatus(autoReplyArticle, false);
	}

	@Override
	public void enable(AutoReplyArticle autoReplyArticle) {
		mapper.setStatus(autoReplyArticle, true);
	}

	@Override
	public AutoReplyArticle getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

	@Override
	public void delete(String uuid) {
		AutoReplyArticle autoReplyArticle = mapper.getByUuid(uuid);
		List<Article> articleList = autoReplyArticle.getArticles();
		if(articleList != null && !articleList.isEmpty()) {
			for(Article article : articleList) {
				//如果自动回复的文章，则删除
				if(article.isAutoReply()) {
					articleMapper.delete(article.getUuid());
				}
			}
		}
		//删除自动回复与文章的关系
		mapper.delAutoReplyArticle(autoReplyArticle);
		//删除自动回复
		mapper.delete(uuid);
	}
	
}
