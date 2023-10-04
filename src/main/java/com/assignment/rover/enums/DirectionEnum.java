package com.assignment.rover.enums;

import lombok.Getter;

@Getter
public enum DirectionEnum {
    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    private final String value;

    DirectionEnum(String value) {
        this.value = value;
    }
}
