package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day00;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static void weightedMean(List<Integer> X, List<Integer> W) {
        int n = X.size();

        BigInteger sum = BigInteger.ZERO;
        BigInteger weightSum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            sum = sum.add(new BigInteger(X.get(i) + "").multiply(new BigInteger(W.get(i) + "")));
            weightSum = weightSum.add(new BigInteger(W.get(i) + ""));
        }

        BigDecimal weightedMean = new BigDecimal(sum).divide(new BigDecimal(weightSum), 1, RoundingMode.HALF_EVEN);
        weightedMean = weightedMean.setScale(1);

        System.out.println(weightedMean);
    }
}

public class Day0WeightedMean {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> weights = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.weightedMean(vals, weights);

        bufferedReader.close();
    }
}
