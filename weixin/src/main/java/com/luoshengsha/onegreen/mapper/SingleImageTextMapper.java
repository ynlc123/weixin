package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.SingleImageText;

/**
 * 单图文回复mapper
 * @author luoshengsha
 * @date 2014年9月10日 上午11:36:36
 */
public interface SingleImageTextMapper extends BaseMapper<SingleImageText> {
	
	/**
	 * 根据关键词获取单图文回复
	 * @param keywords 关键词
	 * @param status 状态
	 * @param paltform 公众平台
	 * @return
	 */
	public SingleImageText getByKeywords(@Param(value="keyword") String keywords, 
			@Param(value="status") int status,	
			@Param(value="platform") Platform  platform);
	
	/**
	 * 设置单图文回复状态
	 * @param uuid
	 * @param status
	 */
	public void setStatus(@Param(value="uuid") Serializable uuid, @Param(value="status") int status);

	/**
	 * 根据uuid获取单图文回复
	 * @param uuid
	 * @return
	 */
	public SingleImageText getByUuid(String uuid);
	
	/**
	 * 根据uuid删除单图文回复
	 * @param uuid
	 */
	public void delete(String uuid);
}
