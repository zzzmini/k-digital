package com.ex.quizCRUD.controller;

import com.ex.quizCRUD.dto.MemberDTO;
import com.ex.quizCRUD.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("member")
public class SessionController {
    @Autowired
    MemberService memberService;

    @GetMapping("login")
    public String loginForm(){
        return "session/loginForm";
    }

    @PostMapping("login")
    public String login(Model model, MemberDTO dto, HttpSession session){
        log.info("controller, "+dto.toString());
        MemberDTO user = memberService.findById(dto);
        if(ObjectUtils.isEmpty(user)){
            // 로그인 실패
            model.addAttribute("msg", "비밀번호 오류입니다.");
            return "session/loginForm";
        }else{
            session.setAttribute("userId", user.getId());
//            session.setMaxInactiveInterval(5);
            session.setMaxInactiveInterval(60*30);
            if(user.getId().equals("root")){  // 관리자 계정 회원목록 조회
                return "redirect:/member/list";
            }else if(!user.getStatus()){
                model.addAttribute("msg", "해당 계정은 관리자 승인이 필요합니다.");
                return "session/loginForm";
            }else{
//                model.addAttribute("user", user);
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
