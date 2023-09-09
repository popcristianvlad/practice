package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day00;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Day0MeanMedianAndMode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new BigInteger(scanner.nextInt() + ""));
        }

        list = list.stream().sorted().collect(Collectors.toList());

        BigDecimal median = n % 2 == 0
                ? new BigDecimal(list.get(n / 2 - 1)).add(new BigDecimal(list.get(n / 2))).divide(new BigDecimal("2"))
                : new BigDecimal(list.get(n / 2));


        BigInteger sum = BigInteger.ZERO;
        Map<BigInteger, Integer> appearances = new HashMap<>();

        for (int i = 0; i < n; i++) {
            BigInteger elem = list.get(i);
            sum = sum.add(elem);

            if (appearances.containsKey(elem)) {
                appearances.put(elem, appearances.get(elem) + 1);
            } else {
                appearances.put(elem, 1);
            }
        }

        BigDecimal average = new BigDecimal(sum).divide(new BigDecimal(n));
        BigDecimal mode = new BigDecimal(appearances.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).max(Comparator.comparing(Map.Entry::getValue)).get().getKey());

        System.out.println(average);
        System.out.println(median);
        System.out.println(mode);
    }
}
