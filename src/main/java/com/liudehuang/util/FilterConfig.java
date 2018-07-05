package com.liudehuang.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liudehuang.filter.LoginFilter;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean loginFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		LoginFilter filter = new LoginFilter();
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setFilter(filter);
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
}
