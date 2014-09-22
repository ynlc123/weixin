package com.luoshengsha.onegreen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.iharder.Base64;

import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 登录过滤器
 * @author luoshengsha
 * @date 2014年8月15日 下午2:49:55
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//验证以center开头的资源路径
		if(request.getRequestURI().startsWith("/center")) {
			if(WebUtil.getLoginCustomer()==null) {//如果用户未登陆，则跳转到登陆页面
				if("ajax".equals(request.getParameter("from"))) {//来自ajax的请求处理
					response.setContentType("application/json;charset=utf-8");
					response.getWriter().print("{\"success\":false,\"isLogout\":true,\"msg\":\"您还没有登陆，请先登陆！\"}");
					return;
				} else {//如果来自非ajax的请求
					String url = request.getRequestURI() + (request.getQueryString() == null ? "" : "?"+ request.getQueryString());
					String sendUrl = Base64.encodeBytes(url.getBytes());
					response.sendRedirect("/login.htm?sendUrl="+sendUrl);
				}
			} else {
				filter.doFilter(req, res);
			}
		} else {
			filter.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(Base64.encodeBytes("http://www.baidu.com?a=sdf&bb=ll3&c=234".getBytes()));
		System.out.println(new String(Base64.decode("aHR0cDovL2xvY2FsaG9zdC9pbmRleC5odG0=")));
	}

}
