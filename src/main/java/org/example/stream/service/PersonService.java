package org.example.stream.service;

import org.example.stream.model.Gender;
import org.example.stream.model.Operator;
import org.example.stream.model.Person;
import org.example.stream.model.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonService {

    public static final String DELIMITER_COMMA = ", ";

    public void filteringByAge(int age, List<Person> persons) {
        System.out.println("Получите список Person и отфильтруйте только те, у которых age > n и выведите в консоль");
        persons.stream()
                .filter(p -> p.getAge() > age)
                .forEach(System.out::println);
    }

    public void filteringByWeight(double weight, List<Person> persons) {
        System.out.println("Получите список Person, отфильтруйте только те, у кого weight > n, преобразуйте в name и выведите в консоль");
        persons.stream()
                .filter(p -> p.getWeight() > weight)
                .map(p -> p.getName())
                .forEach(System.out::println);
    }

    public void filteringByCountPhone(int count, List<Person> persons) {
        System.out.println("Получите список Person, отфильтруйте только те, у кого кол-во телефонов > n, преобразуйте в номера телефонов и выведите в консоль");
        persons.stream()
                .filter(p -> p.getPhones().size() > count)
                .flatMap(p -> p.getPhones().stream())
                .map(phone -> phone.getNumber())
                .forEach(System.out::println);
    }

    public void convertingToLine(List<Person> persons) {
        System.out.println("Получите список Person, преобразуйте в name и затем преобразуйте в строку, что бы имена были через запятую");
        String line = persons.stream()
                .map(p -> p.getName())
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(line);
    }

    public void sortingByReverseAge(List<Person> persons) {
        System.out.println("Получите список Person и отсортируйте их по возрасту в порядке убывания, если возраст равен, то по именам и выведите в консоль");
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed())
                .forEach(System.out::println);
    }

    public void groupingByGender(List<Person> persons) {
        System.out.println("Получите список Person и сгруппируйте их по полу");
        Map<Gender, List<String>> result = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
        result.forEach((gender, personNames) -> System.out.println(gender + " - " + personNames));
    }

    public void checkPhoneNumber(String phoneNumber, List<Person> persons) {
        System.out.println("Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона N значению");
        boolean isPresentPhoneNumber = persons.stream()
                .flatMap(p -> p.getPhones().stream())
                .anyMatch(phone -> phoneNumber.equals(phone.getNumber()));
        System.out.println(String.format("Номер телефона %s в списке присутствует: %b", phoneNumber, isPresentPhoneNumber));
    }

    public void findingDistinctOperators(int index, List<Person> persons) {
        System.out.println("Получите список Person, получите n по порядку человека и получите операторов его телефонов исключая дублирование");
        List<Operator> collect = persons.stream()
                .skip(index - 1)
                .limit(1)
                .flatMap(p -> p.getPhones().stream())
                .map(Phone::getOperator)
                .distinct()
                .collect(Collectors.toList());
        collect
                .forEach(System.out::println);
    }

    public void getAverageWeight(List<Person> persons) {
        System.out.println("Получите список Person и получите их средний вес");
        Double result = persons.stream()
                .collect(Collectors.averagingDouble(Person::getWeight));
        System.out.println(result);
    }

    public void getYoungest(List<Person> persons) {
        System.out.println("Получние список Person и найдите самого младшего по возрасту");
        Optional<Person> minAge = persons.stream()
                .min(Comparator.comparing(Person::getAge));
        if (minAge.isPresent()) {
            System.out.println(minAge.get());
        }
        System.out.println("Не удалось получить минимальнй возраст");
    }

    public void groupingByOperator(List<Person> persons) {
        System.out.println("Получние список Person, получите их телефоны, сгруппируйте по оператору и рeзультатом группировки должны быть только номера телефонов");
        Map<Operator, List<String>> result = persons.stream()
                .flatMap(p -> p.getPhones().stream())
                .collect(Collectors.groupingBy(phone -> phone.getOperator(), Collectors.mapping(Phone::getNumber, Collectors.toList())));
        result.forEach((operator, number) -> System.out.println(operator + " - " + number));
    }

    public void groupingByGenderWithCount(List<Person> persons) {
        System.out.println("Получите список Person и получите их средний вес");
        Map<Gender, Long> result = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        result.forEach((gender, personNames) -> System.out.println(gender + " - " + personNames));
    }


}
