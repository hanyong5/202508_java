package com.study.spring.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
//				.allowedOriginPatterns("http://localhost:3000", "http://localhost:5173", "https://*.vercel.app")
				.allowedOriginPatterns("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("Content-Type", "Authorization").exposedHeaders("Location").allowCredentials(true)
				.maxAge(3600);
		
		registry.addMapping("/bbs/**")
	     .allowedOriginPatterns("*")
	     .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	     .allowedHeaders("Content-Type", "Authorization")
	     .exposedHeaders("Location")
	     .allowCredentials(true)
	     .maxAge(3600);
	}
	
	 
}
