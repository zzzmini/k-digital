package com.ex.basicCRUD.controller;

import com.ex.basicCRUD.dto.MemberDTO;
import com.ex.basicCRUD.entity.Member;
import com.ex.basicCRUD.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("member")
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
}
