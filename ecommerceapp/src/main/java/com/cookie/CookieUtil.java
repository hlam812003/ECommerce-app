package com.cookie;

import jakarta.servlet.http.Cookie;

public class CookieUtil {
    public static String getCookieValue(Cookie[] cookies, String name) {
        String result = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    result = c.getValue();
                    break;
                }
            }
        }

        return result;
    }
}
