package com.my.QuizApplication.controller;

import com.my.QuizApplication.dto.MemberDTO;
import com.my.QuizApplication.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;

    @GetMapping("")
    public String loginFormView() {
        return "loginForm";
    }

    @PostMapping("login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String psw, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberDTO findMember = memberService.findByMemberId(id);
        if (ObjectUtils.isEmpty(findMember)) {
            model.addAttribute("notExist", "존재하지 않는 ID입니다.");
            return "loginForm";
        } else {
            if (findMember.getPassword().equals(psw)) {
                if (findMember.getStatus()) {
                    session.setAttribute("memberDto", findMember);
                    session.setMaxInactiveInterval(60 * 30);
                    return "redirect:/main";
                } else {
                    redirectAttributes.addFlashAttribute("notApprove", "인증되지 않은 ID입니다. 관리자에게 문의해주세요.");
                    return "redirect:/";
                }
            } else {
                redirectAttributes.addFlashAttribute("id", id);
                redirectAttributes.addFlashAttribute("notMatch", "비밀번호가 일치하지 않습니다.");
                return "redirect:/";
            }
        }
    }

    @GetMapping("join")
    public String joinFormView(Model model) {
        model.addAttribute("newMember", new MemberDTO());
        return "joinForm";
    }

    @PostMapping("join")
    public String insertMemberView(@Valid @ModelAttribute("newMember") MemberDTO newMember,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
           model.addAttribute("newMember", newMember);
            return "joinForm";
        }
        boolean result = memberService.insertMember(newMember);
        if (result) {
            return "loginForm";
        } else {
            redirectAttributes.addFlashAttribute("alreadyHas", "이미 등록된 아이디입니다.");
            return "redirect:/join";
        }
    }

    @GetMapping("main")
    public String mainView() {
        return "quizMain";
    }

    @GetMapping("/main/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/main/myPage")
    public String myPageView(HttpSession session) {
        MemberDTO memberDto = (MemberDTO) session.getAttribute("memberDto");
        session.setAttribute("memberDto", memberDto);
        return "myPage";
    }

    @PostMapping("/main/myPage/update")
    public String myInfoModify(@RequestParam("memberId") String id, @RequestParam("psw") String psw, @RequestParam("password") String password,
                               RedirectAttributes redirectAttributes, HttpSession session) {
        MemberDTO originDto = memberService.findByMemberId(id);
        if (originDto.getPassword().equals(psw)) {
            originDto.setPassword(password);
            memberService.updateMember(originDto);
            redirectAttributes.addFlashAttribute("success", "수정되었습니다.");
            session.setMaxInactiveInterval(60 * 30);
        } else {
            redirectAttributes.addFlashAttribute("password",password);
            redirectAttributes.addFlashAttribute("notMatch", "비밀번호가 일치하지 않습니다.");
        }
        return "redirect:/main/myPage";
    }
}
