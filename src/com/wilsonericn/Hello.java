package com.wilsonericn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hello {

    public static String firstLettersCapitalized(List<String> list) {
        String stuff = list.stream()
                .filter(s -> s.length() < 5)
                .map(s -> s.toUpperCase().substring(0, 1))
                .collect(Collectors.joining(""));
        return stuff;
    }

    public static String firstLettersCapitalizedOldWay(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (str.length() < 5) {
                sb.append(str.toUpperCase().substring(0,1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("one","two","three","four","five","six","seven","eight","nine","ten");
        String stuff = Hello.firstLettersCapitalized(numbers);
        String stuff2 = Hello.firstLettersCapitalizedOldWay(numbers);
        System.out.println(stuff);
        System.out.println(stuff2);

    }
}
