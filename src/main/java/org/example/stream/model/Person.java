package org.example.stream.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Person {

    private String name;
    private int age;
    private double weight;
    private Gender gender;
    private List<Phone> phones;

}
