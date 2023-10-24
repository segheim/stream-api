package org.example.stream;

import org.example.stream.model.Person;
import org.example.stream.service.DifferentTaskService;
import org.example.stream.service.PersonService;
import org.example.stream.util.DataCreator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = DataCreator.initPersonData();
        PersonService service = new PersonService();

        service.filteringByAge(30, persons);
        service.filteringByWeight(70, persons);
        service.filteringByCountPhone(3, persons);
        service.convertingToLine(persons);
        service.sortingByReverseAge(persons);
        service.groupingByGender(persons);
        service.checkPhoneNumber("+375335642121", persons);
        service.findingDistinctOperators(3, persons);
        service.getAverageWeight(persons);
        service.getYoungest(persons);
        service.groupingByOperator(persons);
        service.groupingByGenderWithCount(persons);
        service.customCollector(persons);

        DifferentTaskService differentTaskService = new DifferentTaskService();
        differentTaskService.getFrequencyDictionary();
        differentTaskService.getCountOfDaysBetweenDates();
        differentTaskService.calculateAverageText();
        differentTaskService.calculateSumOfRandomNumbers();
    }
}