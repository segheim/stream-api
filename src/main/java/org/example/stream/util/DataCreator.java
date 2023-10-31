package org.example.stream.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.stream.model.Person;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    private DataCreator() {
    }

    public static class Holder {
        public static final DataCreator INSTANCE = new DataCreator();
    }

    public static DataCreator getInstance() {
        return Holder.INSTANCE;
    }

    public List<Person> initPersonDataFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("data/person.json");
        List<Person> persons;
        try {
            persons = mapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    public List<LocalDate> initDates() {
        return new ArrayList<>(List.of(
                LocalDate.of(2020, 01, 10),
                LocalDate.of(2010, 03, 10),
                LocalDate.of(2004, 06, 29),
                LocalDate.of(2015, 07, 23),
                LocalDate.of(2022, 10, 11),
                LocalDate.of(2023, 05, 22)
        ));
    }
}
