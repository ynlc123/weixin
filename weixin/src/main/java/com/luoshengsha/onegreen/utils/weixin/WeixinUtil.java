package com.luoshengsha.onegreen.utils.weixin;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.luoshengsha.onegreen.bean.Fans;
import com.luoshengsha.onegreen.bean.weixin.req.AccessToken;
import com.luoshengsha.onegreen.bean.weixin.req.MenuMessage;

/**
 * 微信工具
 * @author luoshengsha
 * @date 2014年9月4日 下午10:59:10
 */
public class WeixinUtil {
	
	/**
	 * 获取access_token（调用接口凭证）
	 * @param appid 公众号appid
	 * @param appSecret 公众号appSecret
	 * @return 获取成功返回access_token，否则返回null
	 * @throws IOException
	 */
	public static String getAccessToken(String appid, String appSecret) throws IOException {
		try {
			HttpClient client = new HttpClient();
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appSecret;
			PostMethod post = new PostMethod(url);
			int status = client.executeMethod(post);
			if(status==HttpStatus.SC_OK) {
				String respStr = post.getResponseBodyAsString();
				JSONObject jsonObject = JSONObject.fromObject(respStr);
				AccessToken token = (AccessToken) JSONObject.toBean(jsonObject, AccessToken.class);
				return token.getAccess_token();
			}
			return null;
		} catch (HttpException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 获取粉丝基本信息
	 * @param access_token 调用接口凭证
	 * @param openId 普通用户的标识，对当前公众号唯一
	 * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @throws IOException 
	 */
	public static Fans getFansInfo(String access_token, String openId) throws IOException {
		try {
			HttpClient client = new HttpClient();
			String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openId+"&lang=zh_CN";
			PostMethod post = new PostMethod(url);
			int status = client.executeMethod(post);
			if(status==HttpStatus.SC_OK) {
				String respStr = post.getResponseBodyAsString();
				JSONObject jsonObject = JSONObject.fromObject(respStr);
				Fans fans = (Fans) JSONObject.toBean(jsonObject, Fans.class);
				return fans;
			}
			return null;
		} catch (HttpException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 创建自定义菜单
	 * @param access_token 调用接口凭证
	 * @param menuJson json格式的菜单
	 * @return 创建成功返回ok，否则返回null
	 * @throws IOException
	 */
	public static String createMenu(String access_token, String menuJson) throws IOException {
		try {
			HttpClient client = new HttpClient();
			String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
			PostMethod post = new PostMethod(url);
			post.setRequestEntity(new StringRequestEntity(menuJson,"text/json","UTF-8"));
			client.executeMethod(post);
			String respStr = post.getResponseBodyAsString();
			
			JSONObject jsonObject = JSONObject.fromObject(respStr);
			MenuMessage menuMessage = (MenuMessage) JSONObject.toBean(jsonObject, MenuMessage.class);
			return menuMessage.getErrmsg();
		} catch (HttpException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
}
