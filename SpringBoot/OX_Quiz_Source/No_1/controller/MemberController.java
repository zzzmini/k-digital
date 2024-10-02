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
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("")
    public String memberList(Model model){
        List<MemberDTO> memberLists= memberService.findAll();
        model.addAttribute("memberLists", memberLists);
        return "/member/memberList";
    }

    @GetMapping("insert")
    public String insertMemberView(Model model){
        model.addAttribute("newMember", new MemberDTO());
        return "/member/insertMember";
    }

    @PostMapping("insert")
    public String insertMember(@Valid @ModelAttribute("newMember") MemberDTO newMember,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("newMember", newMember);
            return "/member/insertMember";
        }
        boolean result = memberService.insertMember(newMember);
        if (result) {
            return "redirect:/member";
        } else {
            redirectAttributes.addFlashAttribute("alreadyHas", "이미 등록된 아이디입니다.");
            return "redirect:/member/insert";
        }
    }

    @PostMapping("status")
    public String status(@RequestParam("no")Long no){
        memberService.authenticate(no);
        return "redirect:/member";
    }

    @GetMapping("update/{no}")
    public String updateForm(@PathVariable("no")Long no, Model model){
        MemberDTO memberDto = memberService.findByNo(no);
        model.addAttribute("memberDto", memberDto);
        return "/member/updateMember";
    }

    @PostMapping("update")
    public String updateMember(@RequestParam("no")Long no, @RequestParam("password")String psw){
        MemberDTO dto = memberService.findByNo(no);
        dto.setPassword(psw);
        memberService.updateMember(dto);
        return "redirect:/member";
    }

    @PostMapping("delete")
    public String deleteMember(@RequestParam("no")Long no){
        memberService.deleteByNo(no);
        return "redirect:/member";
    }
}
