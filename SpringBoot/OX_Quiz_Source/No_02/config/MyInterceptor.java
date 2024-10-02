package com.ex.OXQuiz.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String loginId = (String) session.getAttribute("login");

        if (ObjectUtils.isEmpty(loginId)) {
            response.sendRedirect("/quiz/login");
            return false;
        }else{
            return true;
        }
    }

}
