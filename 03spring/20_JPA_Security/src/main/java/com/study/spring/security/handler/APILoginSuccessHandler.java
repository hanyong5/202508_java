package com.study.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.study.spring.member.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("----------------login success-------------------");
		log.info(authentication.getPrincipal());
		log.info("----------------login success-------------------");
		
		
		MemberDto memberDto = (MemberDto) authentication.getPrincipal();
		log.info(memberDto);
		
		Map<String, Object> clamis = memberDto.getClaims();
		
		clamis.put("accessToken", "accessToken");
		clamis.put("refreshToken", "refreshToken");
		
		Gson gson = new Gson();
		
		String jsonStr= gson.toJson(clamis);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonStr);
		printWriter.close();
		
	}

}
