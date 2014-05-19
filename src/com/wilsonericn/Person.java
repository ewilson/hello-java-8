package com.wilsonericn;

public class Person {

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
