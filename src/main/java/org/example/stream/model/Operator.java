package org.example.stream.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operator {
    MTS,
    A1,
    Life;

    @JsonCreator
    Operator() {
    }
}
