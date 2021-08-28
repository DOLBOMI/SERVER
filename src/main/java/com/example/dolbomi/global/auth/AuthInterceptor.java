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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		UnauthorizedException {
		try {
			if (isNeedToAuth((HandlerMethod)handler)) {
				String userIdBySession = getUserIdBySession(request);
				String userIdByPath = getUserIdByPathVariable(request);
				if (!userIdBySession.equals(userIdByPath)) {
					throw new UnauthorizedException();
				};
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

	private String getUserIdBySession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return Optional.ofNullable(session.getAttribute(SessionUtil.LOGIN_USER_REGISTER_NO))
			.map(v -> v.toString())
			.orElseThrow(NoAuthorizationData::new);
	}

	private String getUserIdByPathVariable(HttpServletRequest request){
		Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		return Optional.ofNullable(pathVariables.get("id"))
			.orElseThrow(NoAuthorizationData::new);
	}
}

