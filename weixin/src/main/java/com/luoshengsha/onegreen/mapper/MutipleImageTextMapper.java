package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.MutipleImageText;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 多图文回复mapper
 * @author luoshengsha
 * @date 2014年9月29日 下午11:32:01
 */
public interface MutipleImageTextMapper extends BaseMapper<MutipleImageText> {
	/**
	 * 保存多图文回复与文章的关系
	 * @param imageText 多图文回复
	 * @param article 文章
	 */
	public void saveImageTextArticle(@Param(value="imageText") MutipleImageText imageText, @Param(value="article") Article article);
	
	/**
	 * 删除多图文回复与文章的关系
	 * @param imageText 多图文回复
	 */
	public void delImageTextArticle(MutipleImageText imageText);
	
	/**
	 * 根据关键词获取多图文回复
	 * @param keywords 关键词
	 * @return
	 */
	public MutipleImageText getByKeywords(@Param(value="keyword") String keywords, 
				@Param(value="status") int status, 
				@Param(value="platform") Platform platform);
	
	/**
	 * 设置多图文回复状态
	 * @param uuid 多图文uuid
	 * @param status 状态
	 */
	public void setStatus(@Param(value="uuid") Serializable uuid, @Param(value="status") int status);

	/**
	 * 根据uuid获取多图文回复
	 * @param uuid
	 * @return
	 */
	public MutipleImageText getByUuid(Serializable uuid);
	
	/**
	 * 根据uuid删除多图文回复
	 * @param uuid
	 */
	public void delete(Serializable uuid);
}
