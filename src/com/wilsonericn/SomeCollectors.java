package com.wilsonericn;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class SomeCollectors {

    private static List<HockeyPlayer> roster;

    public static void main(String[] args) {
        roster = HockeyPlayer.createCbj();
        System.out.format("Avg Height: %.2f%n", averageHeight());
        System.out.format("Avg Age: %.2f%n", averageAge());
        System.out.format("Number of forwards: %d%n", countForwards());
        System.out.format("Group by position: %s%n", groupByPosition());
        System.out.format("Group Names by age: %s%n", groupNamesByPosition());
    }

    private static double averageHeight() {
        return roster.stream().collect(averagingDouble(Person::getHeight));
    }

    private static double averageAge() {
        return roster.stream().collect(averagingInt(Person::getAge));
    }

    private static Object countForwards() {
        return roster.stream().filter(p -> "F".equals(p.getPosition())).collect(counting());
    }

    private static Map<String, List<HockeyPlayer>> groupByPosition() {
        return roster.stream().collect(groupingBy(HockeyPlayer::getPosition));
    }

    private static Map<Integer, List<String>> groupNamesByPosition() {
        return roster.stream().collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
    }

}
