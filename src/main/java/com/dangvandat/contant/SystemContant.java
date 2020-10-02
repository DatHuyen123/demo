package com.dangvandat.contant;

public class SystemContant {
    public static final int ACTIVE_STAUTS = 1;
    public static final int INACTIVE_STATUS = 0;

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 3600000;//1h
    public static final String SIGNING_KEY = "dangvandat";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";

    //key get in token
    public static final String USER_ID = "userId";
    public static final String FULL_NAME = "fullName";
    public static final String USER_NAME = "username";
}
