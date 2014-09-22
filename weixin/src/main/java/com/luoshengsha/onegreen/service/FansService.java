package com.luoshengsha.onegreen.service;

import com.luoshengsha.onegreen.bean.Fans;

/**
 * 粉丝接口
 * @author luoshengsha
 * @date 2014年9月4日 下午3:10:03
 */
public interface FansService extends BaseDAO<Fans> {
	/**
	 * 关注
	 * @param openId 粉丝openId
	 * @param originalId 公众号原始id
	 */
	public void subscribe(String openId, String originalId);
	
	/**
	 * 取消关注（即删除粉丝）
	 * @param openId 粉丝openId
	 * @param originalId 公众号原始id
	 */
	public void unsubscribe(String openId, String originalId);
	
	/**
	 * 签到
	 * @param openId
	 * @param score 每次签到积分
	 */
	public void sign(String openId,int score);
	
	/**
	 * 校验是否已签到
	 * @param openId
	 * @return 已签到返回true，否则返回false
	 */
	public boolean isSigned(String openId);
	
	/**
	 * 根据openid获取粉丝
	 * @param openid
	 * @return 粉丝
	 */
	public Fans getByOpenid(String openid);
}
