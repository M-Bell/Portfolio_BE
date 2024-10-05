package com.example.Portfolio_BE.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaType {
    IMG, VIDEO;

    @JsonCreator
    public static MediaType fromString(String key) {
        return key == null ? null : MediaType.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getValue() {
        return this.name().toLowerCase();
    }
}
