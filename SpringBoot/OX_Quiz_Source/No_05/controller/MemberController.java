package com.me.oxQuiz.controller;

import com.me.oxQuiz.constant.Answer;
import com.me.oxQuiz.dto.MemberDTO;
import com.me.oxQuiz.dto.QuizDTO;
import com.me.oxQuiz.entity.Member;
import com.me.oxQuiz.service.MemberService;
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
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("view")
    public String showUserList(Model model, HttpSession session) {
        // 사용자가 로그인했는지 확인
        String myId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(myId)) {
            return "redirect:/member/login";
        }
        // 사용자가 관리자인지 확인
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if (Boolean.TRUE.equals(isAdmin)) {
            model.addAttribute("lists", memberService.findAll());
            return "showUser";
        } else {
            return "redirect:/member/login";
        }
    }

    @GetMapping("admin")
    public String adminView(HttpSession session){
        // 사용자가 로그인했는지 확인
        String myId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(myId)){
            return "redirect:/member/login";
        }
        // 사용자가 관리자인지 확인
        boolean isAdmin = (boolean) session.getAttribute("isAdmin");
        if (Boolean.TRUE.equals(isAdmin)){
            return "admin";
        } else {
            return "redirect:/member/login";
        }
    }

    @PostMapping("deactivate")
    public String deactivateMember(@RequestParam("no") Long no){
//        log.info("========= deactivate_no = " + no);
        memberService.deactivateMember(no);
        return "redirect:/member/view";
    }

    @PostMapping("verify")
    public String verifyMember(@RequestParam("no") Long no){
//        log.info("========= verify_no = " + no);
        memberService.verifyMember(no);
        return "redirect:/member/view";
    }

    @PostMapping("update")
    public String updateMember(@Valid @ModelAttribute("dto")MemberDTO dto,
                               BindingResult bindingResult){
//        log.info("========= update_dto = " + dto.toString());

        if(bindingResult.hasErrors()){
            log.info("Errors: " + bindingResult.getAllErrors());
            return "updateMember";
        }

        if(!dto.getPassword().equals(dto.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "confirmPasswordInCorrect","비밀번호가 일치하지 않습니다.");
            return "updateMember";
        }

        memberService.updateMember(dto);
        return "redirect:/member/view";
    }

    @GetMapping("update")
    public String updateMemberView(@RequestParam("no")Long no, Model model, HttpSession session){
        // 로그인 상태 확인 후 세션 만료되었다면 로그인 페이지로 이동
        String myId = (String) session.getAttribute("loginId");
        if(ObjectUtils.isEmpty(myId)) return "loginForm";

        log.info("============ updateNo = " + no);
        MemberDTO dto = memberService.findById(no);
        log.info("========== dto = " + dto.toString());
        model.addAttribute("dto", dto);
        return "updateMember";
    }

    @PostMapping("insert")
    public String insertMember(@Valid @ModelAttribute("dto") MemberDTO dto,
                               BindingResult bindingResult) {
//        log.info("============" + dto.toString());

        if (bindingResult.hasErrors()) {
            return "insertMember";
        }

        // 중복 ID 검사
        if (memberService.isDuplicateMemberId(dto.getMemberId())) {
            bindingResult.rejectValue("memberId", "duplicate", "중복된 ID입니다.");
            return "insertMember";
        }

        // 비밀번호 확인
        if(!dto.getPassword().equals(dto.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "confirmPasswordInCorrect","비밀번호가 일치하지 않습니다.");
            return "insertMember";
        }

        memberService.saveMember(dto);
        return "redirect:/member/login";
    }

    @GetMapping("insert")
    public String insertMemberView(Model model) {
        model.addAttribute("dto", new MemberDTO());
        return "insertMember";
    }
}
