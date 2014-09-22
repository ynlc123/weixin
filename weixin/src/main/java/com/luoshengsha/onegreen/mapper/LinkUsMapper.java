package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.LinkUs;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 关于我们mapper
 * @author luoshengsha
 * @date 2014年9月7日 下午10:02:16
 */
public interface LinkUsMapper {
	/**
	 * 保存“关于我们”
	 * @param linkUs
	 */
	public void save(LinkUs linkUs);
	
	/**
	 * 更新“联系我们”
	 * @param linkUs 联系我们
	 */
	public void update(LinkUs linkUs);
	
	/**
	 * 根据平台获取联系我们
	 * @param platform 平台
	 * @return
	 */
	public LinkUs getByPlatform(Platform platform);
	
	/**
	 * 根据id获取联系我们
	 * @param id
	 * @return
	 */
	public LinkUs find(Serializable id);
	
	/**
	 * 根据uuid获取联系我们
	 * @param uuid
	 * @return
	 */
	public LinkUs getByUuid(String uuid);
}
