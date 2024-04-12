package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Mail {
    NAVER("naver.com"), DAUM("daum.net");
    private final String description;
    Mail(String description) {
        this.description = description;
    }
}
