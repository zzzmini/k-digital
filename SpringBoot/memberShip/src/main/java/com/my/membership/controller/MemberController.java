package com.my.membership.controller;

import com.my.membership.dto.Member;
import com.my.membership.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String newMember() {
        return "createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(Member dto,
                               RedirectAttributes redirectAttributes) {
        log.info("=========" + dto.getName());
        Long result = memberService.join(dto);
        // 중복데이터를 확인해서 처리
        if (result > 0) {
            return "redirect:/";
        } else {
            // 중복 됐을 때
            redirectAttributes
                    .addFlashAttribute("msg",
                            "이미 존재하는 회원입니다.");
            return "redirect:/members/new";
        }
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "memberList";
    }
}
