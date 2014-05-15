package com.wilsonericn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeMath {

    private static List<Integer> findPrimesLessThan(int limit) {
        List<Integer> primes = IntStream.range(2,limit)
                .filter(n -> !IntStream.range(2, n).anyMatch(m -> n % m == 0))
                .boxed().collect(Collectors.toList());
        return primes;
    }

    private static List<Integer> findPrimesOldWay(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int n = 2; n < limit; n++) {
            boolean prime = true;
            for (int m = 2; m < n; m++) {
                if (n % m == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(n);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        List<Integer> primes = findPrimesLessThan(100);
        System.out.println(primes);
        System.out.println(findPrimesOldWay(100));
    }
}
