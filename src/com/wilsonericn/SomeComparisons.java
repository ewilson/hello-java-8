package com.wilsonericn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

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

}

class Person {

    public String name;
    public int age;
    public double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static int compareNames(Person lhs, Person rhs) {
        return lhs.name.compareTo(rhs.name);
    }

    public String toString() {
        return String.format("%-6s %d %.1f", name, age, height);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}
