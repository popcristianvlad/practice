package com.popcristianvlad.hackerrank.practice.algorithms.implementation.AppleAndOrange;

public class AppleAndOrange {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int numberOfApplesOnProperty = 0;
        int numberOfOrangesOnProperty = 0;

        for (int appleDistance : apples) {
            int distance = a + appleDistance;
            if (distance >= s && distance <= t) {
                numberOfApplesOnProperty++;
            }
        }

        for (int orangeDistance : oranges) {
            int distance = b + orangeDistance;
            if (distance >= s && distance <= t) {
                numberOfOrangesOnProperty++;
            }
        }

        System.out.println(numberOfApplesOnProperty);
        System.out.println(numberOfOrangesOnProperty);
    }

    public static void main(String[] args) {
        int s = 7;
        int t = 10;

        int a = 4;
        int b = 12;

        int m = 3;
        int n = 3;

        int[] apples = new int[]{2, 3, -4}; // m elements
        int[] oranges = new int[]{3, -2, -4}; // n elements

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}
