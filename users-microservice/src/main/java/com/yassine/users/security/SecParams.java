package com.yassine.users.security;

public interface SecParams {
	public static final long EXP_TIME = 10 * 24 * 60 * 60 * 1000;
	// ATTENTION : le même secret que dans accessoires-api
	public static final String SECRET = "accessoires-secret-2026-yassine";
	public static final String PREFIX = "Bearer ";
}
