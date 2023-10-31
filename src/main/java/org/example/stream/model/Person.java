package org.example.stream.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonCreator
    public Person(@JsonProperty("name")String name, @JsonProperty("age")int age,
                  @JsonProperty("weight")double weight, @JsonProperty("gender")Gender gender,
                  @JsonProperty("phones")List<Phone> phones) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.phones = phones;
    }
}
