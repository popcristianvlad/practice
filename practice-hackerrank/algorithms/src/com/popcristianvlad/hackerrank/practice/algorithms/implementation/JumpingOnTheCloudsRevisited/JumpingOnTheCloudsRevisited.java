package com.popcristianvlad.hackerrank.practice.algorithms.implementation.JumpingOnTheCloudsRevisited;

public class JumpingOnTheCloudsRevisited {

    static int jumpingOnClouds(int[] c, int k) {
        int currentPosition = 0;
        boolean isFirstMove = true;
        int e = 100;
        int n = c.length;

        while (currentPosition != 0 || isFirstMove) {
            isFirstMove = false;
            currentPosition = (currentPosition + k) % n;
            e--;
            if (c[currentPosition] == 1) {
                e -= 2;
            }
        }

        return e;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        int[] c = new int[]{0, 0, 1, 0, 0, 1, 1, 0}; // n elements

        int result = jumpingOnClouds(c, k);

        System.out.println(result);
    }
}
