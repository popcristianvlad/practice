package com.popcristianvlad.hackerrank.practice.data.structures.arrays.A2DArrayDS;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int currentSum = arr.get(i).get(j);
                currentSum += arr.get(i).get(j + 1);
                currentSum += arr.get(i).get(j + 2);
                currentSum += arr.get(i + 1).get(j + 1);
                currentSum += arr.get(i + 2).get(j);
                currentSum += arr.get(i + 2).get(j + 1);
                currentSum += arr.get(i + 2).get(j + 2);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }
}

public class A2DArrayDS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
