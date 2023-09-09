package com.popcristianvlad.hackerrank.practice.algorithms.implementation.BreakingTheRecords;

public class BreakingTheRecords {

    static int[] breakingRecords(int[] scores) {
        if (scores == null || scores.length == 0) {
            return new int[]{0, 0};
        }

        int maxScore = scores[0];
        int minScore = scores[0];

        int maxScoreBrokeCount = 0;
        int minScoreBrokeCount = 0;

        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
                maxScoreBrokeCount++;
            }

            if (score < minScore) {
                minScore = score;
                minScoreBrokeCount++;
            }
        }

        return new int[]{maxScoreBrokeCount, minScoreBrokeCount};
    }

    public static void main(String[] args) {
        int n = 10;
        int[] scores = new int[]{3, 4, 21, 36, 10, 28, 35, 5, 24, 42}; // n elements

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        System.out.println();

        n = 9;
        scores = new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1}; // n elements

        result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
