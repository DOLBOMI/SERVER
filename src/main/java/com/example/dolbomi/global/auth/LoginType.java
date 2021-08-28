package com.example.dolbomi.global.auth;

import com.example.dolbomi.global.util.session.SessionUtil;

public enum LoginType {

	USER{
		@Override
		public String getSessionKey(){
			return SessionUtil.LOGIN_USER_REGISTER_NO;
		}
	},
	ADMIN{
		@Override
		public String getSessionKey(){
			return SessionUtil.LOGIN_ADMIN_REGISTER_NO;
		}
	};

	public abstract String getSessionKey();
}
