package com.study.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.member.dto.MemberDto;
import com.study.spring.util.JWTUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class MemberController {
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	
	
	@PostMapping("/api/auth/refresh")
    public ResponseEntity<Map<String, Object>> refreshToken(
            @CookieValue(value = "refreshToken", required = false) String refreshToken,
            HttpServletResponse response) {
        
        try {
            // 1) refreshToken 쿠키 확인
            if (refreshToken == null || refreshToken.isEmpty()) {
                log.warn("refreshToken 쿠키가 없습니다.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "refreshToken이 없습니다."));
            }
            
            // 2) refreshToken 검증
            Map<String, Object> claims;
            try {
                claims = JWTUtil.validateToken(refreshToken);
            } catch (Exception e) {
                log.warn("refreshToken 검증 실패: {}", e.getMessage());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "유효하지 않은 refreshToken입니다."));
            }
            
            // 3) 새로운 accessToken 생성
            String newAccessToken = JWTUtil.generateToken(claims, 10); // 10분
            
            // 4) refreshToken 회전 정책: 새로운 refreshToken 생성 및 쿠키 설정
            String newRefreshToken = JWTUtil.generateToken(claims, 60 * 24); // 24시간
            
            Cookie refreshTokenCookie = new Cookie("refreshToken", newRefreshToken);
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setMaxAge(60 * 60 * 24); // 24시간
            refreshTokenCookie.setAttribute("SameSite", "Lax");
            // refreshTokenCookie.setSecure(true); // 프로덕션 환경에서 활성화 권장
            response.addCookie(refreshTokenCookie);
            
            // 5) 응답 반환
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("accessToken", newAccessToken);
            responseBody.put("email", claims.get("email"));
            responseBody.put("nickname", claims.get("nickname"));
            responseBody.put("social", claims.get("social"));
            responseBody.put("roleNames", claims.get("roleNames"));
            
            
            log.info("토큰 갱신 성공: email={}", claims.get("email"));
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
                
        } catch (Exception e) {
            log.error("토큰 갱신 중 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "토큰 갱신 중 오류가 발생했습니다."));
        }
    }
}
