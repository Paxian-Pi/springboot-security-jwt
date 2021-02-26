package com.paxian.bootsecurity.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JwtConstants {
    public static final String SECRET = "mySecretKey";
    public static final int EXPIRATION_TIME = 1800000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";

    public static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);     //go to application properties
}
