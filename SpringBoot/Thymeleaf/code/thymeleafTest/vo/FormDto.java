package com.example.thymeleafTest.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class FormDto {
    private String name;
    private boolean trueOrFalse;
    private List<String> hobbies; //multi-checkbox
    private String language; //radio-button
    private String country;  //select
}
