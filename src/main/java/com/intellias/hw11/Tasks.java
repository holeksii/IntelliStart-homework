package com.intellias.hw11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Tasks {
    public String task1(List<String> names) {
        StringBuilder sb = new StringBuilder();

        names.stream()
                .filter(name -> names.indexOf(name) % 2 != 0)
                .forEach(name -> sb.append(names.indexOf(name))
                                    .append(". ")
                                    .append(name)
                                    .append(", "));

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("...");

        return sb.toString();
    }

    public List<String> task2(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public String task3(String[] numbers) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(numbers)
                .map(number -> number.split(", "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(number -> sb.append(number)
                                    .append(", "));

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // task 4
    public Stream<Long> randInfStream(long a, long c, long m) {
        return Stream.iterate(System.currentTimeMillis(), i -> (a * i + c) % m);
    }

    // task 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return first.reduce(Stream.empty(), (acc, el) -> Stream.concat(acc, Stream.of(el, second.findFirst().get())), Stream::concat);
    }
}
