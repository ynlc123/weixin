package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.ReplyMutipleImageText;
import com.luoshengsha.onegreen.mapper.ArticleMapper;
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
	@Resource
	private ArticleMapper articleMapper;
	
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
		ReplyMutipleImageText imageText = mapper.getByUuid(uuid);
		List<Article> articleList = imageText.getArticles();
		if(articleList != null && !articleList.isEmpty()) {
			for(Article article : articleList) {
				//如果自动回复的文章，则删除
				if(article.isAutoReply()) {
					articleMapper.delete(article.getUuid());
				}
			}
		}
		//删除自动回复与文章的关系
		mapper.delImageTextArticle(imageText);
		//删除自动回复
		mapper.delete(uuid);
	}

	@Override
	public void save(ReplyMutipleImageText imageText) {
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
