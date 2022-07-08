package com.iist.register.enums;

public enum Gender {
    MALE(1),
    FEMALE(2);

    public final int value;

    Gender(final int value) {
        this.value = value;
    }
}
