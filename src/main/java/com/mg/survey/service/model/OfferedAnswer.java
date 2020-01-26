package com.mg.survey.service.model;

import lombok.Getter;

public enum OfferedAnswer {
    ONE(1, "very poor"),
    TWO(2, "poor"),
    THREE(3, "Ok"),
    FOUR(4, "good"),
    FIVE(5, "very good");

    @Getter
    private int code;
    private String description;

    OfferedAnswer(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OfferedAnswer getOfferedAnswerByCode(int id) {
        for (OfferedAnswer r : values()) {
            if (r.getCode() == id) {
                return r;
            }
        }

        return null;
    }
}
