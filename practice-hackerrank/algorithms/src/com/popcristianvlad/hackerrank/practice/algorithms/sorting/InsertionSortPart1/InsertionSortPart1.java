package com.popcristianvlad.hackerrank.practice.algorithms.sorting.InsertionSortPart1;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static void insertionSort1(int n, List<Integer> arr) {
        int storedValue = arr.get(n - 1);

        boolean inserted = false;
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= storedValue) {
                arr.set(i + 1, arr.get(i));
            } else {
                arr.set(i + 1, storedValue);
                inserted = true;
            }
            printList(arr);
            if (inserted) {
                return;
            }
        }

        if (!inserted) {
            arr.set(0, storedValue);
            printList(arr);
        }
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}

public class InsertionSortPart1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
