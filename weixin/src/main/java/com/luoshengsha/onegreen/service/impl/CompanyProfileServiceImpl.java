package com.luoshengsha.onegreen.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.CompanyProfile;
import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.CompanyProfileMapper;
import com.luoshengsha.onegreen.service.CompanyProfileService;

/**
 * 企业介绍接口实现
 * @author luoshengsha
 * @date 2014年9月7日 下午10:46:28
 */
@Service
public class CompanyProfileServiceImpl implements CompanyProfileService {
	@Resource
	private CompanyProfileMapper mapper;
	
	@Override
	public void edit(CompanyProfile profile) {
		if(getByUuid(profile.getUuid())==null) {//保存
			mapper.save(profile);
			//保存简介图片
			saveProfileImages(profile);
		} else {
			mapper.update(profile);
			//删除简介图片
			mapper.delProfileImages(profile.getId());
			//保存简介图片
			saveProfileImages(profile);
		}
	}

	/**
	 * 保存简介图片
	 * @param profile
	 */
	private void saveProfileImages(CompanyProfile profile) {
		if(profile.getImages() != null && !profile.getImages().isEmpty()) {
			for(Image image : profile.getImages()) {
				mapper.saveProfileImages(profile.getId(), image.getId());
			}
		}
	}

	@Override
	public CompanyProfile find(Serializable id) {
		return mapper.find(id);
	}

	@Override
	public CompanyProfile getByPlatform(Platform platform) {
		return mapper.getByPlatform(platform);
	}

	@Override
	public CompanyProfile getByUuid(String uuid) {
		return mapper.getByUuid(uuid);
	}

}
