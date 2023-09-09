package com.popcristianvlad.hackerrank.practice.algorithms.sorting.RunningTimeOfAlgorithms;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result4 {

    public static int runningTime(List<Integer> arr) {
        return insertionSort2(arr.size(), arr);
    }

    public static int insertionSort2(int n, List<Integer> arr) {
        int numberOfShifts = 0;

        if (n == 1) {
            return numberOfShifts;
        }

        for (int i = 1; i < arr.size(); i++) {
            numberOfShifts += insertionSort1(arr, i);
        }

        return numberOfShifts;
    }

    private static int insertionSort1(List<Integer> arr, int unsortedStartingIndex) {
        int numberOfShifts = 0;

        int storedValue = arr.get(unsortedStartingIndex);

        boolean inserted = false;
        for (int i = unsortedStartingIndex - 1; i >= 0; i--) {
            if (arr.get(i) > storedValue) {
                arr.set(i + 1, arr.get(i));
                numberOfShifts++;
            } else {
                arr.set(i + 1, storedValue);
                inserted = true;
            }
            if (inserted) {
                return numberOfShifts;
            }
        }

        if (!inserted) {
            arr.set(0, storedValue);
        }

        return numberOfShifts;
    }
}

public class RunningTimeOfAlgorithms {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result4.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
