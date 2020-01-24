// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi
// Source File Name: CookieUtils.java

package com.zxp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public CookieUtils() {}

    private static String encodeStr(String souStr) {
        return StrUtils.base64Encode(souStr);
    }

    private static String decodeStr(String codeStr) {
        return StrUtils.base64Decode(codeStr);
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] tmpCookies = request.getCookies();
        if (tmpCookies == null || cookieName == null)
            return "";
        int tmpIndex = 0;
        for (int tmpCount = tmpCookies.length; tmpIndex < tmpCount; tmpIndex++)
            if (tmpCookies[tmpIndex].getName().equals(cookieName))
                return decodeStr(tmpCookies[tmpIndex].getValue());

        return "";
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie tmpCookie = new Cookie(cookieName, encodeStr(cookieValue));
        tmpCookie.setPath("/");
        tmpCookie.setMaxAge(315360000);
        response.addCookie(tmpCookie);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int cookieAge) {
        Cookie tmpCookie = new Cookie(cookieName, encodeStr(cookieValue));
        tmpCookie.setMaxAge(cookieAge);
        tmpCookie.setPath("/");
        response.addCookie(tmpCookie);
    }

    public static void setNormalCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie tmpCookie = new Cookie(cookieName, cookieValue);
        tmpCookie.setPath("/");
        tmpCookie.setMaxAge(315360000);
        response.addCookie(tmpCookie);
    }

    public static void setNormalCookie(HttpServletResponse response, String cookieName, String cookieValue,
            int cookieAge) {
        Cookie tmpCookie = new Cookie(cookieName, cookieValue);
        tmpCookie.setMaxAge(cookieAge);
        tmpCookie.setPath("/");
        response.addCookie(tmpCookie);
    }

    public static String getNormalCookie(HttpServletRequest request, String cookieName) {
        Cookie[] tmpCookies = request.getCookies();
        if (tmpCookies == null || cookieName == null)
            return "";
        int tmpIndex = 0;
        for (int tmpCount = tmpCookies.length; tmpIndex < tmpCount; tmpIndex++)
            if (tmpCookies[tmpIndex].getName().equals(cookieName))
                return tmpCookies[tmpIndex].getValue();

        return "";
    }

}
