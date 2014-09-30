package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.ReplyMutipleImageText;

/**
 * 多图文回复mapper
 * @author luoshengsha
 * @date 2014年9月29日 下午11:32:01
 */
public interface ReplyMutipleImageTextMapper extends BaseMapper<ReplyMutipleImageText> {
	/**
	 * 保存多图文回复与文章的关系
	 * @param imageText 多图文回复
	 * @param article 文章
	 */
	public void saveImageTextArticle(@Param(value="imageText") ReplyMutipleImageText imageText, @Param(value="article") Article article);
	
	/**
	 * 删除多图文回复与文章的关系
	 * @param imageText 多图文回复
	 */
	public void delImageTextArticle(ReplyMutipleImageText imageText);
	
	/**
	 * 根据关键词获取多图文回复
	 * @param keywords 关键词
	 * @return
	 */
	public ReplyMutipleImageText getByKeywords(String keywords);
	
	/**
	 * 设置多图文回复状态
	 * @param imageText 多图文回复
	 * @param status 状态
	 */
	public void setStatus(@Param(value="mageText") ReplyMutipleImageText imageText, @Param(value="status") int status);

	/**
	 * 根据uuid获取多图文回复
	 * @param uuid
	 * @return
	 */
	public ReplyMutipleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除多图文回复
	 * @param uuid
	 */
	public void delete(Serializable uuid);
}
