package com.popcristianvlad.hackerrank.practice._30.days.of.code.day19;

import java.util.Scanner;

interface AdvancedArithmetic {

    int divisorSum(int n);
}

class Calculator2 implements AdvancedArithmetic {

    public int divisorSum(int n) {
        int sumOfDivisors = 0;

        for (int i = 1; i <= n / 2; i++) {
            sumOfDivisors += n % i == 0 ? i : 0;
        }

        return sumOfDivisors + n;
    }
}

public class Day19Interfaces {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator2();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
}
