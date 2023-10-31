package org.example.stream.service;

import org.example.stream.util.DataCreator;
import org.example.stream.util.ReaderFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DifferentTaskService {

    public static final String TEXT_PATH = "data/text.txt";
    public static final String TEXT_NUMBER_PATH = "data/numbers.txt";

    public void getFrequencyDictionary() {
        System.out.println("Прочтите содержимое текстового файла и сделайте из него частотный словарик. (слово -> и какое кол-во раз это слово встречается в нём)");
        try (Stream<String> stream = Files.lines(Paths.get(TEXT_PATH))) {
            Map<String, Long> result = stream
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .map(l -> l.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            result.forEach((word, count) -> System.out.println(word + " - " + count));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCountOfDaysBetweenDates() {
        System.out.println("Получите список дат и найдите количество дней между первой и последней датой");
        List<LocalDate> dates = DataCreator.getInstance().initDates();
        LocalDate first = dates.stream().findFirst().orElseGet(LocalDate::now);
        LocalDate last = dates.stream().reduce((a1, a2) -> a2).orElseGet(LocalDate::now);
        long days = ChronoUnit.DAYS.between(first, last);
        System.out.println("Days between " + first + " and " + last + " : " + days);
    }

    public void calculateAverageText() {
        System.out.println("Получите список строк, преобразуйте их в числа, и посчитайте среднее значение (не забудьте отфильтровать не валидные строки)");
        try (Stream<String> stream = Files.lines(Paths.get(TEXT_NUMBER_PATH))) {
            Integer sum = stream.flatMap(s -> Arrays.stream(s.split("\n")))
                    .filter(word -> !word.isEmpty())
                    .map(s -> Integer.valueOf(s))
                    .reduce((a1, a2) -> a1 + a2).orElse(0);
            System.out.println("Amount:" + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateSumOfRandomNumbers() {
        System.out.println("Получите список строк, преобразуйте их в числа, и посчитайте среднее значение (не забудьте отфильтровать не валидные строки)");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        try {
            long sum = forkJoinPool.submit(() -> new Random().longs(1000000)
                    .parallel()
                    .reduce(0L, Long::sum)).get();
            System.out.println("Amount:" + sum);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            forkJoinPool.shutdown();
        }
    }
}
