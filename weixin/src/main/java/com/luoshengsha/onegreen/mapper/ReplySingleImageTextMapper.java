package com.luoshengsha.onegreen.mapper;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.ReplySingleImageText;

/**
 * 单图文回复mapper
 * @author luoshengsha
 * @date 2014年9月10日 上午11:36:36
 */
public interface ReplySingleImageTextMapper extends BaseMapper<ReplySingleImageText> {
	
	/**
	 * 根据关键词获取单图文回复
	 * @param keywords 关键词
	 * @return
	 */
	public ReplySingleImageText getByKeywords(String keywords);
	
	/**
	 * 设置单图文回复状态
	 * @param imageText
	 * @param status
	 */
	public void setStatus(@Param(value="imageText") ReplySingleImageText imageText, @Param(value="status") int status);

	/**
	 * 根据uuid获取单图文回复
	 * @param uuid
	 * @return
	 */
	public ReplySingleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除单图文回复
	 * @param uuid
	 */
	public void delete(String uuid);
}
