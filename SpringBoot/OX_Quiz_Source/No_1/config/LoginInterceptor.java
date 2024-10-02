package com.my.QuizApplication.config;

import com.my.QuizApplication.dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MemberDTO memberDto = (MemberDTO) session.getAttribute("memberDto");
        if (ObjectUtils.isEmpty(memberDto)) {
            response.sendRedirect("/login");
            return false;
        }
        if (request.getRequestURI().startsWith("/member") && !memberDto.getMemberId().equals("root")) {
            response.sendRedirect("/main");
            return false;
        }
        return true;
    }
}
