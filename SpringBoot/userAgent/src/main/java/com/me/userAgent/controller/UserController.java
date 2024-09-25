package com.me.userAgent.controller;

import com.me.userAgent.dto.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("loginCheck/{userName}/{password}")
    public String loginCheckPath(@PathVariable("userName") String user,
                                 @PathVariable("password") String password) {
        if (user.equals("root") && password.equals("1111")) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }

    // localhost:8080/user/loginCheck?user=root&password=1111
    @GetMapping("loginCheck")
    public String loginCheck(@RequestParam("user") String user,
                             @RequestParam("password") String password) {
        if (user.equals("root") && password.equals("1111")) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }

    @GetMapping("")
    public String userPage() {
        return "user";
    }

    @GetMapping("login")
    public String loginPage(Model model) {
        Users users = new Users();
        users.setUserName("root");
        users.setPassword("1111");
        model.addAttribute("users", users);
        return "login";
    }

    @PostMapping("login")
    public String loginPage() {
        return null;
    }
}
