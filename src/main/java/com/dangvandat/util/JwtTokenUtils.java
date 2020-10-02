package com.dangvandat.util;

import com.dangvandat.contant.SystemContant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.CharBuffer;
import java.util.Map;

@Component
public class JwtTokenUtils {

    /*public String decodeJWT(String jwtToken) {
        int firstPeriod = jwtToken.indexOf('.');
        int lastPeriod = jwtToken.lastIndexOf('.');
        CharBuffer buffer = CharBuffer.wrap(jwtToken, 0, firstPeriod);
        buffer.limit(lastPeriod).position(firstPeriod + 1);
        Base64 base64Url = new Base64(true);
        return new String(base64Url.decode(buffer.toString()));
    }*/

    @Autowired
    private ObjectMapper objectMapper;

    public String getUserName(){
        return this.getTokenInfo(SystemContant.USER_NAME).toString();
    }

    public String getFullName(){
        return this.getTokenInfo(SystemContant.FULL_NAME).toString();
    }

    public Long getUserId(){
        return Long.parseLong(this.getTokenInfo(SystemContant.USER_ID).toString());
    }

    public Object getTokenInfo(String key){
        Map<String , Object> additionalInformation = objectMapper.convertValue(SecurityUtils.getPrincipal() , Map.class);
        return additionalInformation.get(key);
    }

}
