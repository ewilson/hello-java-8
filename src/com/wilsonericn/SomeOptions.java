package com.wilsonericn;

import static java.util.Arrays.*;

import static java.util.Arrays.*;
import static java.util.Comparator.comparing;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SomeOptions {

    public static Optional<Fruit> find(String name, List<Fruit> fruits) {
        for(Fruit fruit : fruits) {
            if(fruit.getName().equals(name)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        // Example one
        List<Fruit> fruits = asList(new Fruit("apple"),
                new Fruit("grape"),
                new Fruit("pear"));

        Optional<Fruit> found = find("lemon", fruits);
        if(found.isPresent()) {
            Fruit fruit = found.get();
            String name = fruit.getName();
        }

        // Example two
        Stream<Fruit> fruitStream = asList(new Fruit("apple"),
                new Fruit("grape")).stream();
        Optional<Fruit> max = fruitStream.max(comparing(Fruit::getName));
        if(max.isPresent()) {
            String fruitName = max.get().getName(); //grape
        }
    }
}

class Fruit {
    String name;

    public String getName() {
        return name;
    }

    Fruit(String name) {
        this.name = name;
    }
}
