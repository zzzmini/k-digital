package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Language {
    JAVA("자바"), C("C언어"), CPP("C++"), PYTHON("파이썬");
    private final String description;

    Language(String description) {
        this.description = description;
    }
}
