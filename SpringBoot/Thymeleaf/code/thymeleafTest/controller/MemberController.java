package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @GetMapping("/member")
    public String member(Model model){
        createMember(model);
        return "member";
    }

    @GetMapping("/block")
    public String block(Model model){
        createMember(model);
        return "block";
    }

    private void createMember(Model model) {
        List<Member> memberList = new ArrayList<>();

        for(int i=1; i<=15; i++){
            if(i<10){
                memberList.add(Member.of(i, "Name_0" + i,
                        "addr_0" + i, LocalDateTime.now()));
            } else {
                memberList.add(Member.of(i, "Name_" + i,
                        "addr_" + i, LocalDateTime.now()));
            }
        }
        model.addAttribute("lists", memberList);
    }
}
