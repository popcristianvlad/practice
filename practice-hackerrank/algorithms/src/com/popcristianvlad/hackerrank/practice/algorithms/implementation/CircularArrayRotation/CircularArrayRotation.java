package com.popcristianvlad.hackerrank.practice.algorithms.implementation.CircularArrayRotation;

public class CircularArrayRotation {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int numberOfElements = a.length;
        int numberOfQueries = queries.length;

        if (numberOfElements < k) {
            k = k % numberOfElements;
        }

        for (int i = 0; i < numberOfQueries; i++) {
            queries[i] = a[(numberOfElements - k + queries[i]) % numberOfElements];
        }

        return queries;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int q = 3;

        int[] a = new int[]{1, 2, 3}; // n elements
        int[] queries = new int[]{0, 1, 2}; // q queries

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        System.out.println();

        n = 2;
        k = 4;
        q = 2;

        a = new int[]{1, 2}; // n elements
        queries = new int[]{0, 1}; // q queries

        result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
