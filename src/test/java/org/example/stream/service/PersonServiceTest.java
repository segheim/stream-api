package org.example.stream.service;

import org.example.stream.model.Gender;
import org.example.stream.model.Operator;
import org.example.stream.model.Person;
import org.example.stream.model.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest {

    private List<Person> persons;

    @BeforeEach
    public void init() {
        Person bob = Person.builder()
                .name("Bob")
                .age(10)
                .weight(26.4)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.MTS, "+375297554466")))
                .build();
        Person tom = Person.builder()
                .name("Tom")
                .age(22)
                .weight(77.9)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.MTS, "+375335554466")))
                .build();
        Person elis = Person.builder()
                .name("Elis")
                .age(43)
                .weight(97.9)
                .gender(Gender.FEMALE)
                .phones(List.of(new Phone(Operator.A1, "+375295224466")))
                .build();
        Person julia = Person.builder()
                .name("Julia")
                .age(18)
                .weight(42.5)
                .gender(Gender.FEMALE)
                .phones(List.of(new Phone(Operator.A1, "+375445254466")))
                .build();
        Person donald = Person.builder()
                .name("Donald")
                .age(32)
                .weight(78.6)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.A1, "+375447754466")))
                .build();
        Person henry = Person.builder()
                .name("Henry")
                .age(56)
                .weight(83.2)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.A1, "+375447554460")))
                .build();
        Person hanna = Person.builder()
                .name("Hanna")
                .age(38)
                .weight(64.7)
                .gender(Gender.FEMALE)
                .phones(List.of(new Phone(Operator.MTS, "+375335599466")))
                .build();
        Person bill = Person.builder()
                .name("Bill")
                .age(44)
                .weight(108.1)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.A1, "+375297334460"), new Phone(Operator.MTS, "+375335699121")))
                .build();
        Person lily = Person.builder()
                .name("Lily")
                .age(26)
                .weight(53.4)
                .gender(Gender.FEMALE)
                .phones(List.of(new Phone(Operator.MTS, "+375335554006")))
                .build();
        Person marry = Person.builder()
                .name("Marry")
                .age(68)
                .weight(68.3)
                .gender(Gender.FEMALE)
                .phones(List.of(new Phone(Operator.A1, "+375446754166"), new Phone(Operator.MTS, "+375335642121")))
                .build();
        Person jack = Person.builder()
                .name("Jack")
                .age(73)
                .weight(87.2)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.A1, "+375297754411"), new Phone(Operator.MTS, "+375335642121")))
                .build();
        Person charlie = Person.builder()
                .name("Charlie")
                .age(15)
                .weight(29.7)
                .gender(Gender.MALE)
                .phones(List.of(new Phone(Operator.MTS, "+375335577466")))
                .build();
        persons = new ArrayList<>(List.of(new ))
    }
}