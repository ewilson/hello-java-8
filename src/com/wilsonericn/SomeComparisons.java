package com.wilsonericn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class SomeComparisons {

    public static Person james = new Person("James", 45, 6.5);
    public static Person josh = new Person("Josh", 35, 6.5);
    public static Person martin = new Person("Martin", 45, 5.9);
    public static Person rich = new Person("Rich", 50, 6.1);

    public static List<Person> people = Arrays.asList(rich, james, josh, martin);

    public static void main(String[] args) {
        System.out.println(people);
        sortByAgeOldWay();
        reverseSortByAgeUsingLambda();
        sortByNameUsingMethod();
        sortByHeightUsingField();
        sortByAgeThenHeight();
        sortByAgeThenHeightReversed();
        System.out.println(people);
    }

    public static void sortByAgeOldWay() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });
    }

    private static void reverseSortByAgeUsingLambda() {
        Collections.sort(people, (p1, p2) -> p2.age - p1.age);
    }

    private static void sortByNameUsingMethod() {
        Collections.sort(people, Person::compareNames);
    }

    private static void sortByHeightUsingField() {
        Collections.sort(people, comparing(Person::getHeight));
    }

    private static void sortByAgeThenHeight() {
        Collections.sort(people, comparing(Person::getAge).thenComparing(Person::getHeight));
    }

    private static void sortByAgeThenHeightReversed() {
        Collections.sort(people, comparing(Person::getAge).thenComparing(comparing(Person::getHeight).reversed()));
    }

}
