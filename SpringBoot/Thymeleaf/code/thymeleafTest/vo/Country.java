package com.example.thymeleafTest.vo;

import lombok.Getter;

@Getter
public enum Country {
    KOREA("대한민국"), USA("미국"), JAPAN("일본"),
    CHINA("중국"), SINGAPRE("싱가폴");
    private final String description;
    Country(String description) {
        this.description = description;
    }
}
