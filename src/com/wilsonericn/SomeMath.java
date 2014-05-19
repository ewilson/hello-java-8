package com.wilsonericn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeMath {

    private static List<Integer> findPrimesLessThan(int limit) {
        return IntStream.range(2,limit)
                .filter(n -> !IntStream.range(2, n).anyMatch(m -> n % m == 0))
                .boxed().collect(Collectors.toList());
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

    private static int leastCommonMultipleOfList(List<Integer> nums) {
        return nums.stream().reduce(1,(x,y) -> x * y / gcd(x, y));
    }

    private static int leastCommonMultipleOfListOldWay(List<Integer> nums) {
        int lcm = 1;
        for (int num : nums) {
            lcm = lcm * num / gcd(lcm, num);
        }
        return lcm;
    }

    public static void main(String[] args) {
        System.out.println(findPrimesLessThan(100));
        System.out.println(findPrimesOldWay(100));
        System.out.println(leastCommonMultipleOfList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(leastCommonMultipleOfListOldWay(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    private static int gcd(int x, int y) {
        int a;
        int b;
        if (x > y) {
            a = x;
            b = y;
        } else {
            b = x;
            a = y;
        }
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

}
