package com.popcristianvlad.hackerrank.practice.algorithms.sorting.BigSorting;

import java.util.Arrays;

public class BigSorting {

    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, (x, y) -> x.length() == y.length() ? x.compareTo(y) : Integer.compare(x.length(), y.length()));
        return unsorted;
    }

    public static void main(String[] args) {
        int n = 6;

        String[] unsorted = new String[n];
        unsorted[0] = "31415926535897932384626433832795";
        unsorted[1] = "1";
        unsorted[2] = "3";
        unsorted[3] = "10";
        unsorted[4] = "3";
        unsorted[5] = "5";

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
