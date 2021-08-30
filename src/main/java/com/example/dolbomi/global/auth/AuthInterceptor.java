package com.example.dolbomi.global.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

import com.example.dolbomi.global.exeption.NoAuthorizationData;
import com.example.dolbomi.global.exeption.UnauthorizedException;
import com.example.dolbomi.global.util.session.SessionUtil;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws UnauthorizedException {
		try {
			if (isNeedToAuth((HandlerMethod)handler)) {
				getAdminIdBySession(request);
			}
			return true;
		} catch (Exception e) {
			throw new UnauthorizedException(e);
		}
	}

	private boolean isNeedToAuth(HandlerMethod handler){
		if (handler.getMethodAnnotation(AuthRequired.class) == null) {
			return false;
		}
		return true;
	}

	private String getAdminIdBySession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return Optional.ofNullable(session.getAttribute(SessionUtil.LOGIN_ADMIN_REGISTER_NO))
			.map(v -> v.toString())
			.orElseThrow(NoAuthorizationData::new);
	}
}

