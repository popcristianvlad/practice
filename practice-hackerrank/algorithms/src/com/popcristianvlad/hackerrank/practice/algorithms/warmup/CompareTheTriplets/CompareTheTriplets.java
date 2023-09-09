package com.popcristianvlad.hackerrank.practice.algorithms.warmup.CompareTheTriplets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alicePoints = 0;
        int bobPoints = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alicePoints++;
            }
            if (a.get(i) < b.get(i)) {
                bobPoints++;
            }
        }

        return Arrays.asList(alicePoints, bobPoints);
    }
}

public class CompareTheTriplets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
