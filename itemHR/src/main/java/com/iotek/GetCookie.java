package com.iotek;

import javax.servlet.http.Cookie;

/**
 * Created by 11929 on 2019/7/19.
 */
public class GetCookie {
    public static Cookie getC(Cookie[] cookies,String keyname){
        if(cookies!=null&&cookies.length!=0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(keyname)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
