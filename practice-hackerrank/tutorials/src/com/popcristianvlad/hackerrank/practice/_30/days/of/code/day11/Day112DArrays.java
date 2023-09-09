package com.popcristianvlad.hackerrank.practice._30.days.of.code.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day112DArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> hourglassStartIndexes = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                hourglassStartIndexes.add(Arrays.asList(i, j));
            }
        }

        int maxSum = -9 * 7;

        for (List<Integer> hourglassStartIndex : hourglassStartIndexes) {
            int i = hourglassStartIndex.get(0);
            int j = hourglassStartIndex.get(1);

            int currentSum = 0;
            for (int k = 0; k < 3; k++) {
                currentSum += arr.get(i).get(j + k);
                currentSum += arr.get(i + 2).get(j + k);
            }
            currentSum += arr.get(i + 1).get(j + 1);

            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }

        System.out.println(maxSum);

        bufferedReader.close();
    }
}
