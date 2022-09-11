package com.intellias.algorithms;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Person {
    private int height;
    private int weight;
    private int age;

    public Person(int height, int weight, int age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
}