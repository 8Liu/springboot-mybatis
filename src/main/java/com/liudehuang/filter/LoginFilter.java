package com.liudehuang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String path = request.getContextPath();
		System.out.println(path);
		String url = request.getRequestURI();
		System.out.println(url);
		url = url.substring(path.length());
		System.out.println(url);
		if(url.endsWith("/hello")||url.contains("user")) {
			chain.doFilter(request, response);
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("请重新登陆");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
