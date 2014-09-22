package com.luoshengsha.onegreen.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.luoshengsha.onegreen.bean.Customer;

/**
 * webUtil
 * @author luoshengsha
 * @date 2014年8月5日 下午3:33:56
 */
public class WebUtil {
	
	/**
	 * 获取登录用户
	 * @return 已登录用户
	 */
	public static Customer getLoginCustomer() {
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return (Customer) request.getSession().getAttribute("loginCustomer");
	}
	
	/**
	 * 用utf-8格式输出传入的json字符串
	 * @param response
	 * @param isSuccess 是否执行成功
	 * @param message 提示信息
	 */
	public static void print2JsonMsg(HttpServletResponse response, boolean isSuccess, String message) {
		try {
			response.setContentType("application/json;charset=utf-8");
			
			response.getWriter().print("{\"success\":"+isSuccess+",\"msg\":\""+message+"\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用utf-8格式输出传入的xml字符串
	 * @param response
	 * @param isSuccess 是否执行成功
	 * @param message 提示信息
	 */
	public static void print2XmlMsg(HttpServletResponse response, boolean isSuccess, String message) {
		PrintWriter pw = null;  
        try {  
            response.setContentType("text/xml;charset=utf-8");   
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Cache-Control", "no-cache");  
            pw = response.getWriter();

            StringBuffer sf = new StringBuffer();
            sf.append("<xml>");
            sf.append("<success>"+isSuccess+"</success>");
            sf.append("<message>"+message+"</message>");
            sf.append("</xml>");

            pw.print(message);  
            pw.flush();  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally {  
            if (pw != null)  
                pw.close();  
        }
	}
	
	/**
	 * 用utf-8格式输出传入的json字符串
	 * @param response
	 * @param isSuccess 是否执行成功
	 * @param message 提示信息
	 */
	public static void print2JsonData(HttpServletResponse response, boolean isSuccess, String data) {
		try {
			response.setContentType("application/json;charset=utf-8");
			
			response.getWriter().print("{\"success\":"+isSuccess+",\"data\":["+data+"]}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * 校验是否是手机号码
     * @param mobile 手机号
     * @return 
     * @author luoshengsha
     */
    public static boolean isMobile(String mobile) {
    	if(mobile==null || mobile.trim().equals("")) return false;
    	return mobile.matches("^0?(13[0-9]|15[0123456789]|18[0123456789]|14[57])[0-9]{8}$");
    }
}
