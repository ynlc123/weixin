package com.luoshengsha.onegreen.service;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Image;

/**
 * 图片接口
 * @author luoshengsha
 * @date 2014年9月7日 下午10:17:06
 */
public interface ImageService extends BaseDAO<Image> {
	/**
	 * 更新图片
	 * @param image 图片
	 */
	public void update(Image image);
	
	/**
	 * 删除图片
	 * @param id
	 */
	public void delete(Serializable id);
}
