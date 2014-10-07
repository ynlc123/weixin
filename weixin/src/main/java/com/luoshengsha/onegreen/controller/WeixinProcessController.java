package com.luoshengsha.onegreen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.DefaultMessage;
import com.luoshengsha.onegreen.bean.MutipleImageText;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.ReplyText;
import com.luoshengsha.onegreen.bean.SingleImageText;
import com.luoshengsha.onegreen.bean.weixin.res.Item;
import com.luoshengsha.onegreen.bean.weixin.res.ResNewsMessage;
import com.luoshengsha.onegreen.bean.weixin.res.ResTextMessage;
import com.luoshengsha.onegreen.service.DefaultMessageService;
import com.luoshengsha.onegreen.service.MutipleImageTextService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.service.ReplyTextService;
import com.luoshengsha.onegreen.service.SingleImageTextService;
import com.luoshengsha.onegreen.utils.ImageUtil;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.weixin.MessageUtil;
import com.luoshengsha.onegreen.utils.weixin.SignUtil;

/**
 * 微信处理控制器
 * @author luoshengsha
 * @date 2014年10月4日 下午8:44:39
 */
@Controller
@RequestMapping(value="/weixin/process.htm")
public class WeixinProcessController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(WeixinProcessController.class);
    
    @Resource
    private PlatformService platformService;
	@Resource
	private DefaultMessageService defMsgService;
	@Resource
	private ReplyTextService textService;
	@Resource
	private SingleImageTextService singleImageTextService;
	@Resource
	private MutipleImageTextService mutipleImageTextService;
	/**
	  * 
	  * @param request
	  * @param response
	  */
	 @RequestMapping(method=RequestMethod.GET)
	 public void get(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 微信加密签名
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串
			String echostr = request.getParameter("echostr");

			PrintWriter out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
			out.close();
			out = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 /**
	 * 处理微信请求
	 * @param request
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void post(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			//默认返回的文本消息内容
			String respContent = "欢迎您的关注！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			
			//获取公众号
			Platform platform = platformService.getByOriginalId(toUserName);
			
			// 消息类型
			String msgType = requestMap.get("MsgType");
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "欢迎关注滇赐有机工坊！";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					
					//解绑微信与账户
					//userService.unbindWeixin(fromUserName);
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					/*User loginUser = WebUtil.getLoginUser();
					if(loginUser==null) {
						loginUser = userService.getByWeixinId(fromUserName);
						if(loginUser != null) {
							session.setAttribute("loginUser", loginUser);
						}
					}
					
					if("SUYUAN".equals(requestMap.get("EventKey"))) {//溯源
						respContent = "功能正在完善中,敬请期待...";
					} else if("ZHONGCHOU".equals(requestMap.get("EventKey"))) {//众酬
						respContent = "功能正在完善中,敬请期待...";
					}*/
				} else {
					respContent = "欢迎您的关注！";
				}
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 接收用户发送的文本消息内容  
                String content = requestMap.get("Content");
                
                ReplyText replyText = textService.getByKeyword(content, platform);
                if(replyText != null) {//文本回复
            		respWeixin(response, fromUserName, toUserName, replyText.getContent());
                } else {
                	List<Item> itemList = new ArrayList<Item>();
                	SingleImageText singleImageText = singleImageTextService.getByKeywords(content, platform);
                	if(singleImageText != null) {//单图文回复
	                	ResNewsMessage newsMessage = new ResNewsMessage();
	                	newsMessage.setToUserName(fromUserName);  
	                    newsMessage.setFromUserName(toUserName);  
	                    newsMessage.setCreateTime(new Date().getTime());  
	                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
	                	
	                	Item item = new Item();
	                	//标题
	                	item.setTitle(singleImageText.getTitle());  
	                    //简短描述
	                	String textContent = WebUtil.htmlFilter(singleImageText.getContent());
	                    item.setDescription(textContent.length()>50 ? textContent.substring(0,50) : textContent);
	                    //图片
	                    item.setPicUrl(ImageUtil.PICTURE_URL+singleImageText.getImage().getPath());  
	                    item.setUrl("http://114.215.110.9/view/singleImageText/detail.htm?uuid="+singleImageText.getUuid());
	                    itemList.add(item);  
	                    newsMessage.setArticleCount(1);  
	                    newsMessage.setArticles(itemList);  
	                    String respMessage = MessageUtil.newsMessageToXml(newsMessage);
	                    //响应消息
	            		PrintWriter out = response.getWriter();
	            		out.print(respMessage);
	            		out.close();
	            System.out.println("respMessage: "+ respMessage);
                	} else {
                		MutipleImageText mutipleImageText = mutipleImageTextService.getByKeywords(content, 1, platform);
                		if(mutipleImageText != null) {//多图文回复
                			ResNewsMessage newsMessage = new ResNewsMessage();
                			newsMessage.setToUserName(fromUserName);  
                            newsMessage.setFromUserName(toUserName);  
                            newsMessage.setCreateTime(new Date().getTime());  
                            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                			
                			for(Article article : mutipleImageText.getArticles()) {
	                			Item item = new Item();
	                            item.setTitle(article.getTitle());
	                            //简短描述
	    	                	String itemDescription = WebUtil.htmlFilter(item.getDescription());
	    	                    item.setDescription(itemDescription.length()>50 ? itemDescription.substring(0,50) : itemDescription);
	    	                    
	                            item.setDescription(article.getContent().substring(0,50));
	                            item.setPicUrl(ImageUtil.PICTURE_URL+article.getImage().getPath());
	                            item.setUrl("http://114.215.110.9/view/article/detail.htm?uuid="+article.getUuid());
	                            itemList.add(item);
                			}

                            newsMessage.setArticleCount(itemList.size());
                            newsMessage.setArticles(itemList);
                            String respMessage = MessageUtil.newsMessageToXml(newsMessage);
                            
                            //响应消息
    	            		PrintWriter out = response.getWriter();
    	            		out.print(respMessage);
    	            		out.close();
                		} else {
                			DefaultMessage defmsg = defMsgService.getByPlatform(platform);
                			if(defmsg != null) {//默认回复
                				respWeixin(response, fromUserName, toUserName, defmsg.getContent());
                			} else {//回复“欢迎您的关注”
                				respWeixin(response, fromUserName, toUserName, respContent);
                			}
                		}
                	}
                }
			} else {
				respContent = "欢迎您的关注！";
				respWeixin(response, fromUserName, toUserName, respContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回复微信消息
	 * @param response
	 * @param fromUserName 订阅者id
	 * @param toUserName 服务号id
	 * @throws IOException
	 */
	private void respWeixin(HttpServletResponse response, String fromUserName,
			String toUserName, String msg) throws IOException {
		// 回复文本消息
		ResTextMessage textMessage = new ResTextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setContent(msg);
		String respMessage = MessageUtil.textMessageToXml(textMessage);
		
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}
}
