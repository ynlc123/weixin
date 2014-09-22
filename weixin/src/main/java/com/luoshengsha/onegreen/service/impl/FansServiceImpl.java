package com.luoshengsha.onegreen.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luoshengsha.onegreen.bean.Fans;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.mapper.BaseMapper;
import com.luoshengsha.onegreen.mapper.FansMapper;
import com.luoshengsha.onegreen.service.FansService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.TimeUtil;
import com.luoshengsha.onegreen.utils.weixin.WeixinUtil;

/**
 * 粉丝接口实现
 * @author luoshengsha
 * @date 2014年9月4日 下午3:11:42
 */
@Service
public class FansServiceImpl extends DAOSupport<Fans> implements FansService {
	@Resource
	private FansMapper mapper;
	@Resource
	private PlatformService platformService;
	
	@Override
	protected BaseMapper<Fans> getMapper() {
		return mapper;
	}

	@Override
	public void subscribe(String openId, String originalId) {
		Platform platform = platformService.getByOriginalId(originalId);
		if(platform.getPlatformType()==1 && platform.isAuth()) {//判断是否是服务号？（ 1：服务号 0：订阅号），并且是否已通过微信认证
			//如果公众号为服务号并且已通过微信认证，则可以通过openid获取粉丝的相关信息
			try {
				String access_token = WeixinUtil.getAccessToken(platform.getAppId(), platform.getAppSecret());
				Fans fans = WeixinUtil.getFansInfo(access_token, openId);
				mapper.save(fans);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//如果不符合上述要求的公众号，则保存粉丝的openid
			Fans fans = new Fans();
			fans.setOpenid(openId);
			mapper.save(fans);
		}
	}

	@Override
	public void unsubscribe(String openId, String originalId) {
		Platform platform = platformService.getByOriginalId(originalId);
		mapper.unSubscribe(openId, platform);
	}

	@Override
	public void sign(String openId, int score) {
		mapper.sign(openId, score, new Date());
	}

	@Override
	public boolean isSigned(String openId) {
		Fans fans = mapper.getByOpenid(openId);
		long days = TimeUtil.getDaysToToday(fans.getLastestSignTime());
		return days==0l ?  true : false;
	}

	@Override
	public Fans getByOpenid(String openid) {
		return mapper.getByOpenid(openid);
	}

}
