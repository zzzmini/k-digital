package com.ex.basicCRUD.controller;

import com.ex.basicCRUD.dto.MemberDTO;
import com.ex.basicCRUD.entity.Member;
import com.ex.basicCRUD.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping({"", "view"})
    public String showMembers(Model model) {
        model.addAttribute("lists",
                memberService.findAll());
        return "showMember";
    }

    @GetMapping("insert")
    public String insertFormView() {
        return "insertMember";
    }

    @PostMapping("insert")
    public String insertMember(MemberDTO dto) {
        log.info("########" + dto.toString());
        memberService.saveMember(dto);
        return "redirect:/member";
    }

    @PostMapping("delete")
    public String deleteMember(@RequestParam("id")Long id) {
        log.info("######## deleteId = " + id);
        memberService.deleteMember(id);
        return "redirect:/member";
    }
    @GetMapping("update")
    public String updateFormView(@RequestParam("id")Long id
                                , Model model) {
        log.info("######## updateId = " + id);
        MemberDTO dto = memberService.findById(id);
        log.info("######## dto = " + dto.toString());
        model.addAttribute("dto", dto);
        return "updateMember";
    }

    @PostMapping("update")
    public String updateMember(MemberDTO dto) {
        log.info("######## updatedto = " + dto.toString());
        return "redirect:/member";
    }
}
