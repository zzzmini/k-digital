package com.example.oxquizproject.controller;

import com.example.oxquizproject.dto.MemberDTO;
import com.example.oxquizproject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")
@Slf4j
public class SessionController {
    @Autowired
    MemberService memberService;

    @GetMapping("login")
    public String loginFormView() {
        return "loginMember";
    }

    @PostMapping("login")
    public String login(MemberDTO dto, HttpSession session, Model model) {
        String myId = memberService.findById(dto);
        if (ObjectUtils.isEmpty(myId)) {
            //로그인 실패
            model.addAttribute("errorMessage", "관리자에게 문의하세요.");
            return "loginMember";
        } else if (myId.equals("wrong")) {
            //아이디 및 비번 틀림
            model.addAttribute("errorMessage", "아이디 및 비밀번호를 확인하세요.");
            return "loginMember";
        } else {
            //로그인 성공
            session.setAttribute("loginId", myId);
            session.setMaxInactiveInterval(60*30);
            return "main";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "main";
    }

}
