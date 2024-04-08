package com.example.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {

    @GetMapping("/mylink/link")
    public String linkTest(Model model) {
        model.addAttribute("name", "장원영");
        model.addAttribute("age", 21);
        return "/link/linkView";
    }

    @GetMapping("hello")
    public String helloPage(){
        return "/link/hello_page";
    }

    @GetMapping("/requestParam")
//  http://localhost/requestParm?name=장원영&age=21
    public String reqParam(@RequestParam("name") String name,
                           @RequestParam("age")int age,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("title", "Request Param");
        return "link/resultView";
    }

    @GetMapping("/pathVariable/{name}/{age}")
//    http://localhost/pathVariable/장원영/21
    public String pathVariable(@PathVariable("name") String name,
                               @PathVariable("age") int age,
                               Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("title", "Path Variable");
        return "link/resultView";
    }
    @GetMapping("/pathAndQuery/{name}")
//    /hello/장원영?age=21
    public String pathAndQuery(@PathVariable("name") String name,
                               @RequestParam("age") int age,
                               Model model){

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("title", "Path Variable + query parameter");
        return "link/resultView";
    }
}
