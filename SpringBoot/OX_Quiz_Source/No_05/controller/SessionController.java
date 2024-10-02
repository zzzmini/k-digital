package com.me.oxQuiz.controller;

import com.me.oxQuiz.dto.MemberDTO;
import com.me.oxQuiz.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("member")
public class SessionController {

    @Autowired
    MemberService memberService;

    @GetMapping("login")
    public String loginFormView(){
        return "loginForm";
    }

    @PostMapping("login")
    public String login(MemberDTO dto, HttpSession session, Model model){
        log.info(dto.toString());
        String myId = memberService.findByUserId(dto);

        if(ObjectUtils.isEmpty(myId)){
            // 로그인 실패 (ID 또는 비밀번호가 틀림)
            model.addAttribute("errorMessage","아이디 또는 비밀번호가 잘못되었습니다.");
            return "loginForm";
        } else if (myId.equals("inactive")){
            // status가 false인 경우
            model.addAttribute("errorMessage", "관리자에게 문의하십시오.");
            return "loginForm";
        } else {
            // 로그인 성공
            session.setAttribute("loginId", myId);
//            session.setMaxInactiveInterval(15);
            session.setMaxInactiveInterval(60*30);

            // 관리자 여부도 세션에 저장 & 관리자 페이지로 이동
            if (memberService.isAdmin(myId)){
                session.setAttribute("isAdmin", true);
                return "redirect:/member/admin";
            } else {
                session.setAttribute("isAdmin", false);
                return "main";
            }
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main";
    }

}
