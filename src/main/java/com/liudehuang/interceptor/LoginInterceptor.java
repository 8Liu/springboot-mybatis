package com.liudehuang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * HandlerInterceptor在调用controller之前和调用controller之后以及视图渲染完成之后都可以得到控制；我们不可以通过拦截器来修改request内容，但是我们可以通过抛出异常或者返回false来结束请求

　　技巧01：拦截器可以获取到原始的请求和响应信息，也可以拿到controlelr层的类名信息和方法名信息；但是拿不到方法的参数信息；因为DispatcherServlet在进行请求分发时先执行拦截器，然后在将请求数据封装到controller层中控制方法的参数上去的。
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * 视图渲染完成之后
　　　　　　技巧01：不管controller层是否抛出异常都会执行该方法，只有preHandle返回false或者preHandle方法中抛出异常才不会执行该方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception exception)
			throws Exception {
		
	}
	/**
	 * 调用controller之后视图渲染完成之前
　　　　　　技巧01：如果controller层中的方法抛出了异常就会不会执行该方法了
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView model)
			throws Exception {
	}
	
	/**
	 * 调用controller之前执行，如果该方法返回false或者抛出异常就会结束请求
	 * 技巧01：preHandle返回false或者抛出异常是就不会在继续往下执行（即：不会在今日conroller层，也不会执行postHandle和afterCompletion）
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		String url = req.getRequestURI();
		String path = req.getContextPath();
		url = url.substring(path.length());
		if(url.contains("user")) {
			return true;
		}else {
			return false;
		}
	}

}
