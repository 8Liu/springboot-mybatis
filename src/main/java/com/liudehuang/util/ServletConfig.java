package com.liudehuang.util;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liudehuang.servlet.HelloServlet;
import com.liudehuang.servlet.ServletTest;

@Configuration
public class ServletConfig {
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new ServletTest(),"/servlet");
	}
	
	@Bean
	public ServletRegistrationBean helloServlet() {
		return new ServletRegistrationBean(new HelloServlet(),"/hello");
	}
}
