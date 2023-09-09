package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result4 {

    public static void stdDev(List<Integer> arr) {
        int dataSetSize = arr.size();

        BigDecimal sumOfElements = BigDecimal.ZERO;
        for (int i = 0; i < dataSetSize; i++) {
            sumOfElements = sumOfElements.add(new BigDecimal(arr.get(i)));
        }

        BigDecimal average = sumOfElements.divide(new BigDecimal(dataSetSize));

        BigDecimal sumOfSquareMagnitudes = BigDecimal.ZERO;
        for (int i = 0; i < dataSetSize; i++) {
            BigDecimal magnitude = new BigDecimal(arr.get(i)).subtract(average);
            sumOfSquareMagnitudes = sumOfSquareMagnitudes.add(magnitude.pow(2));
        }

        MathContext mc = new MathContext(6, RoundingMode.HALF_EVEN);
        BigDecimal standardDeviation = sumOfSquareMagnitudes.divide(new BigDecimal(dataSetSize)).sqrt(mc);
        standardDeviation = standardDeviation.setScale(1, RoundingMode.HALF_EVEN);

        System.out.println(standardDeviation);
    }
}

public class Day1StandardDeviation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result4.stdDev(vals);

        bufferedReader.close();
    }
}
