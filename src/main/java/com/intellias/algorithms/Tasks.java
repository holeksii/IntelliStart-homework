package com.intellias.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Tasks {
    /**
     * <b>Task 1<b/>
     */
    private void sortByAge(Person[] people) {
        Arrays.sort(people, Comparator.comparingInt(Person::getAge));
    }

    /**
     * <b>Task 2<b/>
     */
    private void sortByWeight(Person[] people) {
        Arrays.sort(people, Comparator.comparing(Person::getWeight));
    }

    /**
     * <b>Task 2<b/>
     */
    private void sortByHeight(Person[] people) {
        Arrays.sort(people, Comparator.comparing(Person::getHeight));
    }

    /**
     * <b>Task 3<b/>
     * Complexity: O(n log n) + O(n) = O(n log n)
     */
    private int uniquePeopleCount(Person[] people) {
        // O(n log n)
        Arrays.sort(people, (p1, p2) -> {
            if (Comparator.comparingInt(Person::getHeight).compare(p1, p2) == 0) {
                return Comparator.comparingInt(Person::getWeight).compare(p1, p2);
            }
            return Comparator.comparingInt(Person::getHeight).compare(p1, p2);
        });

        int count = 0;

        // O(n)
        for (int i = 0; i < people.length; i++) {
            if (i == 0 || (people[i].getWeight() != people[i - 1].getWeight()
                    || people[i].getHeight() != people[i - 1].getHeight())) {
                count++;
            }
        }

        return count;
    }
}
