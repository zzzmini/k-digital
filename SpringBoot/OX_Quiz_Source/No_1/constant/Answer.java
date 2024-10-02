package com.my.QuizApplication.constant;

import lombok.Getter;

@Getter
public enum Answer {
    TRUE("O"),
    FALSE("X");
    public final String desc;

    Answer(String desc) {
        this.desc = desc;
    }
}
