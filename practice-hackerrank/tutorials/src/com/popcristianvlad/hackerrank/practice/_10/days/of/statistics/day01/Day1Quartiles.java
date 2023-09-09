package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day01;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    public static List<Integer> quartiles(List<Integer> arr) {
        arr.sort(Integer::compareTo);
        int numberOfElements = arr.size();
        int lowerHalfIndex = numberOfElements / 2 - 1;
        int upperHalfIndex = numberOfElements % 2 == 1
                ? numberOfElements / 2 + 1
                : numberOfElements / 2;

        int quartile1 = findMedian(arr, 0, lowerHalfIndex);
        int quartile2 = findMedian(arr, 0, numberOfElements - 1);
        int quartile3 = findMedian(arr, upperHalfIndex, numberOfElements - 1);

        return Arrays.asList(quartile1, quartile2, quartile3);
    }

    private static int findMedian(List<Integer> arr, int lowerHalfIndex, int upperHalfIndex) {
        int numberOfElements = upperHalfIndex - lowerHalfIndex + 1;
        return numberOfElements % 2 == 1
                ? arr.get(lowerHalfIndex + numberOfElements / 2)
                : (arr.get(lowerHalfIndex + (numberOfElements / 2 - 1)) + arr.get(lowerHalfIndex + numberOfElements / 2)) / 2;
    }
}

public class Day1Quartiles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = Result2.quartiles(data);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
