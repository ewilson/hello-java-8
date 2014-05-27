package com.wilsonericn;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SomeFunctionalInterfaces {

    private static List<HockeyPlayer> roster;

    public static void main(String[] args) {
        roster = HockeyPlayer.createCbj();
        printForwards25andUnder();
    }

    private static void printForwards25andUnder() {
        Predicate<HockeyPlayer> isForward = p -> "F".equals(p.getPosition());
        Predicate<Person> twentyFiveOrUnder = p -> 25 >= p.getAge();
        roster.stream().filter(isForward.and(twentyFiveOrUnder)).forEach(System.out::println);
        doSomethingWithRestriction(roster, isForward.and(twentyFiveOrUnder), System.out::println);
    }

    private static void doSomethingWithRestriction(List<HockeyPlayer> players,
                                                   Predicate<HockeyPlayer> filter,
                                                   Consumer<HockeyPlayer> doSomething) {
        players.stream().filter(filter).forEach(doSomething);
    }
}
