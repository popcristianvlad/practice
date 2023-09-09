package com.popcristianvlad.hackerrank.practice.algorithms.implementation.NumberLineJumps;

public class NumberLineJumps {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            return "YES";
        }

        if (v1 == v2) {
            return "NO";
        }

        int numerator = x2 - x1;
        int denominator = v1 - v2;

        if (numerator < 0 && denominator > 0) {
            return "NO";
        }

        if (numerator > 0 && denominator < 0) {
            return "NO";
        }

        if (numerator % denominator == 0) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        int x1 = 0;
        int v1 = 3;

        int x2 = 4;
        int v2 = 2;

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        x1 = 0;
        v1 = 2;

        x2 = 5;
        v2 = 3;

        result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);
    }
}
