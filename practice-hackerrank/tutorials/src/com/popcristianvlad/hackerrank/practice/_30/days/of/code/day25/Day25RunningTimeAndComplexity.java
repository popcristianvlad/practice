package com.popcristianvlad.hackerrank.practice._30.days.of.code.day25;

import java.util.Scanner;

public class Day25RunningTimeAndComplexity {

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int number = sc.nextInt();
            System.out.println(isPrime(number) ? "Prime" : "Not prime");
        }
    }
}
