package com.me.thymeleafTest.controller;

import com.me.thymeleafTest.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "basic", method = RequestMethod.GET)
public class BasicController {
    @GetMapping("condition")
    public String condition(Model model) {
        List<User> userList = addUser();
        model.addAttribute("userList", userList);
        return "basic/condition";
    }

    @GetMapping("each")
    public String each(Model model) {
        List<User> userList = addUser();
        model.addAttribute("userList", userList);
        return "basic/each";
    }

    private List<User> addUser() {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("안유진", 22),
                        new User("장원영", 21),
                        new User("이서", 18),
                        new User("가을", 23),
                        new User("리즈", 21),
                        new User("레이", 21)
                )
        );
        return userList;
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("name", "홍길동");
        return "basic/operation";
    }


    @GetMapping("link")
    public String link(Model model) {
        model.addAttribute("name", "안유진");
        model.addAttribute("age", 22);
        User user = new User("김형민", 10);
        model.addAttribute("kim", user);
        return "basic/link";
    }

    @GetMapping("/date")
    public String date(Model model){
        String url = "/basic/date";
        model.addAttribute("localDateTime",
                LocalDateTime.now());
        return url;
    }

    @GetMapping("text-basic")
    public String textBasic(Model model){
        model.addAttribute("data", "Test");
        model.addAttribute("name", "장원영");
        model.addAttribute("age", 20);
        return "text-basic";
    }

    @GetMapping("/variables")
    public String variable(Model model) {
//        localhost:8080/basic/variables
        User kim = new User("김형민", 20);
        User hong = new User("홍길동", 30);
        System.out.println(kim);
        // 오브젝트를 모델에 담기
        model.addAttribute("kim", kim);
        List<User> userList = new ArrayList<>();
        userList.add(kim);
        userList.add(hong);
//        리스트를 모델에 담기
        model.addAttribute("userList", userList);

        // 맵에 담아서 보내기
        Map<String, User> userMap = new HashMap<>();
        userMap.put("kim", kim);
        userMap.put("hong", hong);
        model.addAttribute("userMap", userMap);
        return "basic/variable";
    }
}
