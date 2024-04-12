package com.example.thymeleafTest.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String id;
    private String password1;
    private String password2;
    private String name;
    private String birth;
    private String gender;
    private List<String> agreeList;
    private String email1;
    private String email2;
    private String phone;
}
