package com.popcristianvlad.algorithms.practice;

public class EuclidsAlgorithm {

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 42));
        System.out.println(gcd(21, 7));
        System.out.println(gcd(9, 10));
    }
}
