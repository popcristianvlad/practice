package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day04;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Day4BinomialDistributionI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double boyRatio = scanner.nextDouble();
        double girlRatio = scanner.nextDouble();
        scanner.close();

        double successProbability = boyRatio / (boyRatio + girlRatio);
        double failureProbability = 1 - successProbability;

        int n = 6;
        int x = 3;

        double binomialDistribution = 0;
        for (int i = x; i <= 6; i++) {
            double combinationsOfNtakenKTimes = factorial(n).doubleValue() / factorial(n - i).multiply(factorial(i)).doubleValue();
            binomialDistribution += combinationsOfNtakenKTimes * Math.pow(successProbability, i) * Math.pow(failureProbability, n - i);
        }

        System.out.println(new DecimalFormat("#.###").format(binomialDistribution));
    }

    private static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }

        return factorial;
    }
}
