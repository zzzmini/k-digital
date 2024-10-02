package com.me.oxQuiz.constant;

import lombok.Getter;

@Getter
public enum Answer {
    O("O"),
    X("X");
    private final String desc;

    Answer(String desc) {
        this.desc = desc;
    }
}
