package com.fatsecret.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fatsecret.common.FileManagerService;
import com.fatsecret.interceptor.PermissionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private PermissionInterceptor intereceptor;	//로그인정도만 검사해준다
	
	//web에 이미지 주소와 실제 파일 경로를 매핑해주는 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**")	// 이미지의 웹 주소 http://localhost/images/aaaa_135465413/sun.png
									
		//맥에선 슬래시를 한개만 써준다
		.addResourceLocations("file://" + FileManagerService.FILE_UPLOAD_PATH); //실제 파일이 있는 곳
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//인터셉터의 이름을 넣어준다									
		registry.addInterceptor(intereceptor)
		.addPathPatterns("/**")		//	/** = 아래 패스까지 모두 확인
		.excludePathPatterns("/error", "/static/**", "/user/sign_out");	//static으로 이어지는 하위 나머지들 전부를 제외한다
	}
}	
