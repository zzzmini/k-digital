package com.example.thymeleafTest.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    MALE("남자"), FEMALE("여자")
    ,NONE("선택안함");
    private final String description;
    Gender(String description) {
        this.description = description;
    }
}
