package com.study.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.study.spring.member.dto.MemberDto;
import com.study.spring.util.JWTUtil;

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
		
//		clamis.put("accessToken", JWTUtil.generateToken(clamis,10));
//		clamis.put("refreshToken", JWTUtil.generateToken(clamis,60*24));
		
		String accessToken = JWTUtil.generateToken(clamis,10);
		String refreshToken = JWTUtil.generateToken(clamis,60*24);
		
		
//		httponly
		jakarta.servlet.http.Cookie refreshTokenCookie = 
				new jakarta.servlet.http.Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setPath("/");
		refreshTokenCookie.setMaxAge(60*60*24);
		refreshTokenCookie.setAttribute("SameSite", "Lax"); // SameStie = Strict,Lax,None
		response.addCookie(refreshTokenCookie);
		
		
		
		clamis.put("accessToken",accessToken);
		
		Gson gson = new Gson();
		
		String jsonStr= gson.toJson(clamis);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonStr);
		printWriter.close();
		
	}

}
