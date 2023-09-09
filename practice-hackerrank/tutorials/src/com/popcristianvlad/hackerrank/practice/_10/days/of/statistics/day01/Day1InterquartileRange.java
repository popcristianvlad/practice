package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day01;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result3 {

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        List<Integer> dataSet = createDataSet(values, freqs);

        int numberOfElements = dataSet.size();
        int lowerHalfIndex = numberOfElements / 2 - 1;
        int upperHalfIndex = numberOfElements % 2 == 1
                ? numberOfElements / 2 + 1
                : numberOfElements / 2;

        double quartile1 = findMedian(dataSet, 0, lowerHalfIndex);
        double quartile3 = findMedian(dataSet, upperHalfIndex, numberOfElements - 1);

        System.out.println(quartile3 - quartile1);
    }

    private static List<Integer> createDataSet(List<Integer> values, List<Integer> freqs) {
        int numberOfDistinctValues = values.size();
        List<Integer> dataSet = new ArrayList<>();

        for (int i = 0; i < numberOfDistinctValues; i++) {
            for (int j = 0; j < freqs.get(i); j++) {
                dataSet.add(values.get(i));
            }
        }

        dataSet.sort(Integer::compareTo);

        return dataSet;
    }

    private static double findMedian(List<Integer> arr, int lowerHalfIndex, int upperHalfIndex) {
        int numberOfElements = upperHalfIndex - lowerHalfIndex + 1;
        return numberOfElements % 2 == 1
                ? arr.get(lowerHalfIndex + numberOfElements / 2)
                : (arr.get(lowerHalfIndex + (numberOfElements / 2 - 1)) + arr.get(lowerHalfIndex + numberOfElements / 2)) / 2;
    }
}

public class Day1InterquartileRange {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result3.interQuartile(val, freq);

        bufferedReader.close();
    }
}
