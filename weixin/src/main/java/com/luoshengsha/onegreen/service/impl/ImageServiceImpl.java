package com.luoshengsha.onegreen.service.impl;

import java.io.File;
import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.ImageMapper;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.utils.ImageUtil;

/**
 * 图片接口实现
 * @author luoshengsha
 * @date 2014年9月7日 下午10:18:22
 */
@Service
public class ImageServiceImpl extends DAOSupport<Image> implements ImageService {

	@Resource
	private ImageMapper mapper;
	
	@Override
	protected BaseMapper<Image> getMapper() {
		return mapper;
	}

	@Override
	public void update(Image image) {
		mapper.update(image);
	}
	
	@Override
	public void delete(Serializable id) {
		//删除物理图片
		delPhysicalPic(id);
		//删除数据库中的图片信息
		mapper.delete(id);
	}

	/**
	 * 删除物理图片
	 * @param id 
	 * @author luoshengsha
	 */
	private void delPhysicalPic(Serializable id) {
		//从图片服务器中删除图片
		Image image = find(id);
		if(!StringUtils.isEmpty(image.getPath())){
			/***** 普通图片（包括64*64,100*100,150*150,220*220,310*310,原图） ****/
			File pic_64 = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", "64"));
			if(pic_64.exists()) {//删除64*64图
				pic_64.delete();
			}
			File pic_100 = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", "100"));
			if(pic_100.exists()) {//删除100*100图
				pic_100.delete();
			}
			File pic_150 = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", "150"));
			if(pic_150.exists()) {//删除150*150图
				pic_150.delete();
			}
			File pic_220 = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", "220"));
			if(pic_220.exists()) {//删除220*220图
				pic_220.delete();
			}
			File pic_310 = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", "310"));
			if(pic_310.exists()) {//删除310*310图
				pic_310.delete();
			}
			File pic = new File(ImageUtil.PIC_PERSIST_PATH+"/"+image.getPath().replace("_min", ""));
			if(pic.exists()) {//删除原图
				pic.delete();
			}
		}
	}
}
