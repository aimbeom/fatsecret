package com.fatsecret.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fatsecret.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	//web에 이미지 주소와 실제 파일 경로를 매핑해주는 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**")	// 이미지의 웹 주소 http://localhost/images/aaaa_135465413/sun.png
									
		//맥에선 슬래시를 한개만 써준다
		.addResourceLocations("file://" + FileManagerService.FILE_UPLOAD_PATH); //실제 파일이 있는 곳
	}
}	
