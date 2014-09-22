package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.LinkUs;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 联系我们
 * @author luoshengsha
 * @date 2014年9月7日 下午9:45:33
 */
public interface LinkUsService {
	/**
	 * 编辑“联系我们”
	 * 若还不存在，则保存；若已存在，则更新
	 * @param linkUs 联系我们
	 */
	public void edit(LinkUs linkUs);
	
	/**
	 * 根据平台获取联系我们
	 * @param platform 平台
	 * @return
	 */
	public LinkUs getByPlatform(Platform platform);
	
	/**
	 * 根据uuid获取联系我们
	 * @param uuid
	 */
	public LinkUs getByUuid(String uuid);
}
