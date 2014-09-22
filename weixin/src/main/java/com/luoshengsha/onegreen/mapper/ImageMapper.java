package com.luoshengsha.onegreen.mapper;

import java.io.Serializable;

import com.luoshengsha.onegreen.bean.Image;

/**
 * 图片mapper
 * @author luoshengsha
 * @date 2014年9月7日 下午10:14:58
 */
public interface ImageMapper extends BaseMapper<Image> {
	/**
	 * 删除图片
	 * @param id
	 */
	public void delete(Serializable id);
}
