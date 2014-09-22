package com.luoshengsha.onegreen.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.luoshengsha.onegreen.bean.Fans;
import com.luoshengsha.onegreen.bean.Platform;

/**
 * 粉丝mapper
 * @author luoshengsha
 * @date 2014年9月4日 下午3:07:12
 */
public interface FansMapper extends BaseMapper<Fans> {
	/**
	 * 取消关注
	 * @param fans 粉丝
	 * @param platform 公众号
	 */
	public void unSubscribe(@Param(value="openId") String openId, 
			@Param(value="platform") Platform platform);
	
	/**
	 * 签到
	 * @param openId 
	 * @param score 每次签到所得积分
	 * @param time 签到时间
	 */
	public void sign(@Param(value="openId") String openId, @Param(value="score")int score, @Param(value="signTime") Date time);

	/**
	 * 根据openid获取粉丝
	 * @param openid
	 * @return
	 */
	public Fans getByOpenid(String openid);
}
