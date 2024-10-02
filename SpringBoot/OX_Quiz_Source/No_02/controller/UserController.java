package com.ex.OXQuiz.controller;

import com.ex.OXQuiz.dto.MemberDTO;
import com.ex.OXQuiz.dto.QuizDTO;
import com.ex.OXQuiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("quiz")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("signIn")
    public String showSignIn(Model model) {
        model.addAttribute("dto", new MemberDTO());
        return "signIn";
    }

    @PostMapping("signIn")
    public String signIn(@Valid @ModelAttribute("dto") MemberDTO dto, BindingResult bindingResult, Model model) {
        log.info("==== dto : " + dto.toString());

        // 아이디 중복 확인
        if (userService.memberIdExists(dto.getMemberId())) {
            model.addAttribute("signInError", "중복된 아이디입니다.");
            return "signIn";
        }

        //validation
        if (bindingResult.hasErrors()) return "signIn";

        userService.insertUser(dto);
        return "redirect:/quiz";
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute("dto") MemberDTO dto, BindingResult bindingResult, HttpSession session, Model model) {
        log.info("==== dto : " + dto.toString());

        //validation
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginError", "Invalid login details");
            return "login";
        }

        MemberDTO member = userService.findByMemberId(dto);
//        log.info("==== member : " + member.toString());

        //아이디 확인
        if (ObjectUtils.isEmpty(member)) {
            model.addAttribute("loginError", "사용자를 찾을 수 없습니다.");
            return "login";
        }
        //비밀번호 확인
        if (member.getMemberPassword() == null) {
            model.addAttribute("loginError", "비밀번호가 일치하지 않습니다.");
            return "login";
        }

        //아이디가 root인지 확인
        if (member.getMemberId().equals("root")) {
            session.setAttribute("login", member.getMemberId());
            session.setMaxInactiveInterval(60*30);
            return "redirect:/quiz";
        }

        //일반 사용자일 경우, status 값이 1인지 확인
        if (member.getStatus()) {
            session.setAttribute("login", member.getMemberId());
            session.setMaxInactiveInterval(60*30);
            return "redirect:/quiz";
        } else {
            model.addAttribute("loginError", "관리자의 승인이 필요합니다.");
            return "login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/quiz";
    }

    @GetMapping("managerView")
    public String showManagerView(Model model) {
        List<MemberDTO> lists = userService.findAllUsers();
        log.info("find all users : " + lists);
        model.addAttribute("lists", lists);
        return "managerView";
    }

    @PostMapping("userStatusChange")
    public String userStatusChange(@RequestParam("id") Long id) {
        log.info("#### user id = " + id);
        MemberDTO dto = userService.findById(id);
        dto.setStatus(true);
        userService.updateUser(dto);

        return "redirect:/quiz/managerView";
    }

    @PostMapping("userDelete")
    public String deleteUser(@RequestParam("id") Long id) {
        log.info("#### user id = " + id);
        MemberDTO dto = userService.findById(id);
        dto.setStatus(false);
        userService.updateUser(dto);
        return "redirect:/quiz/managerView";
    }

    @GetMapping("userUpdate")
    public String showUpdateUser(@RequestParam("id") Long id, Model model, HttpSession session) {
        //현재 로그인 상태인지 확인
        String myId = (String) session.getAttribute("login");

        //세션이 만료되었다면 로그인 페이지로 이동
        if(ObjectUtils.isEmpty(myId)) return "loginForm";

        //그렇지 않다면 수정 처리
        log.info("########updateId=" + id);

        model.addAttribute("dto", userService.findById(id));
        return "updateUser";
    }

    @PostMapping("userUpdate")
    public String updateUser(@ModelAttribute("dto") MemberDTO dto, BindingResult bindingResult, HttpSession session) {
        //validation
        if (bindingResult.hasErrors()) return "updateUser";

        //user 비밀번호 외 값 유지해주기
        dto.setStatus(true);
        dto.setAnswerTrue(dto.getAnswerTrue());
        dto.setAnswerFalse(dto.getAnswerFalse());
        MemberDTO updateDto = userService.updateUser(dto);

        // 세션 정보 업데이트
        session.setAttribute("login", updateDto.getMemberId());
        session.setMaxInactiveInterval(60*30);
        return "redirect:/quiz/managerView";
    }

}
