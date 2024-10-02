package com.example.oxquizproject.controller;

import com.example.oxquizproject.dto.MemberDTO;
import com.example.oxquizproject.dto.QuizDTO;
import com.example.oxquizproject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
    @Autowired
    MemberService memberService;


    @GetMapping("")
    public String showMain(Model model, HttpSession session) {
        return "main";
    }

    @GetMapping("signup")
    public String signupFormView(Model model) {
        model.addAttribute("dto", new MemberDTO());
        return "signupMember";
    }

    @PostMapping("signup")
    public String signupMember(@Valid @ModelAttribute("dto") MemberDTO dto, BindingResult bindingResult, Model model) {
        log.info("################" + dto.toString());
        //오류가 있으면 insertMember로 다시 돌아가겠다
        if (bindingResult.hasErrors()) {
            log.info("====================Validation Error");
            return "signupMember";
        }
        // 관리자가 이미 등록되어 있으면 1 반환
        int result = memberService.saveMember(dto);
        if (result == 1) {
            model.addAttribute("errorMessage", "이미 등록된 관리자가 존재합니다.");
            return "signupMember";  // 다시 회원가입 페이지로 이동
        } else {
            return "redirect:/member";
        }
    }

    @GetMapping("admin")
    public String admin(Model model, HttpSession session) {
        //현재 로그인 상태인지 확인하고,
        //세션이 만료가 되었다면, 로그인 페이지로 이동...
        //세션 정보를 가져옴
        String myId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(myId)) return "loginMember";

        model.addAttribute("lists", memberService.findAll());
        return "adminMember";

    }

    @PostMapping("certify")
    public String certifyStatus(@RequestParam("no") Long no) {
        memberService.certifyStatus(no);
        return "redirect:/member/admin";
    }

    @GetMapping("update")
    public String updateFormView(@RequestParam("no") Long no, Model model, HttpSession session) {
        //현재 로그인 상태인지 확인하고,
        //세션이 만료가 되었다면, 로그인 페이지로 이동...
        //세션 정보를 가져옴
        String myId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(myId)) return "loginMember";
        log.info("################ updateId = " + no);
        MemberDTO dto = memberService.findByNo(no);
        log.info("################ dto = " + dto.toString());
        model.addAttribute("dto", dto);
        return "updateMember";
    }

    @PostMapping("update")
    public String updateMember(@Valid @ModelAttribute("dto") MemberDTO dto, BindingResult bindingResult, HttpSession session) {
        log.info("################ dto = " + dto.toString());
        if (bindingResult.hasErrors()) {
            return "updateMember";
        }
        MemberDTO updateDto = memberService.updateMember(dto);
        session.setAttribute("loginId", updateDto.getId());
        session.setMaxInactiveInterval(60*30);
        return "redirect:/member/admin";
    }

    @PostMapping("delete")
    public String deleteStatus(@RequestParam("no") Long no) {
        memberService.deleteStatus(no);
        return "redirect:/member/admin";
    }
}
