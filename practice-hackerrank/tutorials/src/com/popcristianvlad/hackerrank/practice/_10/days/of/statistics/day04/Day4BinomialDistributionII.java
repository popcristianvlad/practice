package com.popcristianvlad.hackerrank.practice._10.days.of.statistics.day04;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Day4BinomialDistributionII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int defectivePistonsPercentage = scanner.nextInt();
        int sizeOfCurrentBatch = scanner.nextInt();
        scanner.close();

        double successProbability = defectivePistonsPercentage * 0.01;
        double failureProbability = 1 - successProbability;

        int n = sizeOfCurrentBatch;

        int noMoreThan2Rejects = 2;
        int atLeast2Rejects = 2;

        double noMoreThan2RejectsBinomialDistribution = 0;
        for (int i = 0; i <= noMoreThan2Rejects; i++) {
            double combinationsOfNtakenKTimes = factorial(n).doubleValue() / factorial(n - i).multiply(factorial(i)).doubleValue();
            noMoreThan2RejectsBinomialDistribution += combinationsOfNtakenKTimes * Math.pow(successProbability, i) * Math.pow(failureProbability, n - i);
        }

        double atLeast2RejectsBinomialDistribution = 0;
        for (int i = atLeast2Rejects; i <= n; i++) {
            double combinationsOfNtakenKTimes = factorial(n).doubleValue() / factorial(n - i).multiply(factorial(i)).doubleValue();
            atLeast2RejectsBinomialDistribution += combinationsOfNtakenKTimes * Math.pow(successProbability, i) * Math.pow(failureProbability, n - i);
        }

        System.out.println(new DecimalFormat("#.###").format(noMoreThan2RejectsBinomialDistribution));
        System.out.println(new DecimalFormat("#.###").format(atLeast2RejectsBinomialDistribution));
    }

    private static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }

        return factorial;
    }
}
