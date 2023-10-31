package org.example.stream.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    MALE,
    FEMALE,
    SOME;

    @JsonCreator
    Gender() {
    }
}
