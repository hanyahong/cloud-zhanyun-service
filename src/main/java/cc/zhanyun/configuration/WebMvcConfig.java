package cc.zhanyun.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cc.zhanyun.util.AccessTokenVerifyInterceptor;

/**
 * MVC 设置
 * 
 */

public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public AccessTokenVerifyInterceptor tokenVerifyInterceptor() {
		return new AccessTokenVerifyInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/client");
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/offer");
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/project");
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/resources");
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/location");
//		registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns(
//				"/file");

		super.addInterceptors(registry);
	}

}