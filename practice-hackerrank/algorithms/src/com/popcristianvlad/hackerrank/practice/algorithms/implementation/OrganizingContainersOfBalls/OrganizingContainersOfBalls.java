package com.popcristianvlad.hackerrank.practice.algorithms.implementation.OrganizingContainersOfBalls;

import java.util.Arrays;

public class OrganizingContainersOfBalls {

    static String organizingContainers(int[][] container) {
        int n = container.length;
        int rowSums[] = new int[n];
        int columnSums[] = new int[n];

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int columnSum = 0;

            for (int k = 0; k < n; k++) {
                rowSum += container[i][k];
                columnSum += container[k][i];
            }

            rowSums[i] = rowSum;
            columnSums[i] = columnSum;
        }

        Arrays.sort(rowSums);
        Arrays.sort(columnSums);

        if (Arrays.equals(rowSums, columnSums)) {
            return "Possible";
        }

        return "Impossible";
    }

    public static void main(String[] args) {
        int[][] container = new int[][]{
                {1, 1},
                {1, 1},
        };
        String result = organizingContainers(container);
        System.out.println(result);

        container = new int[][]{
                {0, 2},
                {1, 1},
        };
        result = organizingContainers(container);
        System.out.println(result);

        container = new int[][]{
                {1, 3, 1},
                {2, 1, 2},
                {3, 3, 3}
        };
        result = organizingContainers(container);
        System.out.println(result);

        container = new int[][]{
                {0, 2, 1},
                {1, 1, 1},
                {2, 0, 0}
        };
        result = organizingContainers(container);
        System.out.println(result);
    }
}
