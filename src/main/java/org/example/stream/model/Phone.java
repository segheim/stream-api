package org.example.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {

    private Operator operator;
    private String number;

}
