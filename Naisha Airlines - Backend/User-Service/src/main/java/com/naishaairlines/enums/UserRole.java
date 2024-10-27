package com.naishaairlines.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    USER("User"),
    ADMIN("Administrator"),
    STAFF("Staff");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

}
