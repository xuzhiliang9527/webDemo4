package com.woniuxy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginChecked
 */
@WebFilter("/LoginChecked")
public class LoginChecked implements Filter {
	//过滤掉未登录用户
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest res = (HttpServletRequest) request;
		res.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = res.getSession();
		System.out.println("执行过滤器");
		if(session.getAttribute("teacher")!=null) {
			chain.doFilter(request, response);
		}
		else
			request.getRequestDispatcher("jsp/LoginFailed.jsp").forward(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}
	@Override
	public void destroy() {
		
	}

}
