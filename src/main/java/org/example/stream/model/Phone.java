package org.example.stream.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Phone {

    private Operator operator;
    private String number;

    @JsonCreator
    public Phone(@JsonProperty("operator")Operator operator, @JsonProperty("number")String number) {
        this.operator = operator;
        this.number = number;
    }
}
