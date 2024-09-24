package com.me.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
    // http://localhost:8080/linkTest/장원영?age=22
    @GetMapping("linkTest/{name}")
    public String pathAndParam(Model model,
                               @PathVariable("name")String name,
                               @RequestParam("age")int age){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "/basic/linkTest";
    }

    // http://localhost:8080/linkTest/장원영/21
    @GetMapping("linkTest/{name}/{age}")
    public String pathTest(Model model,
                            @PathVariable("name")String name,
                           @PathVariable("age")int age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "/basic/linkTest";
    }

    @GetMapping("linkTest")
    public String linkTest(Model model,
                           @RequestParam("pName")String name,
                           @RequestParam("pAge")int age){
        name = "나는 장원영";
        age = age + 1;
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "/basic/linkTest";
    }
}
