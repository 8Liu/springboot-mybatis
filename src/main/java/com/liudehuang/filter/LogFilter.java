package com.liudehuang.filter;

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

import org.springframework.core.annotation.Order;
@Order(1)
@WebFilter(filterName="logFilter",urlPatterns="/*")
public class LogFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("自定义过滤器销毁操作");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("自定义过滤器过滤操作");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String path = request.getContextPath();
		String url = request.getRequestURI();
		url = url.substring(path.length());
		if(url.endsWith("/myServlet")||url.contains("user")) {
			chain.doFilter(request, response);
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("请重新登陆");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("自定义过滤器初始化操作");
	}

}
