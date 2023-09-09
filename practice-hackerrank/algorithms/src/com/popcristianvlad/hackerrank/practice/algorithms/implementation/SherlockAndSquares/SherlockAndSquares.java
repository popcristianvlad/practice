package com.popcristianvlad.hackerrank.practice.algorithms.implementation.SherlockAndSquares;

public class SherlockAndSquares {

    static int squares(int a, int b) {
        int floorA = (int) Math.floor(Math.sqrt(a));
        int floorB = (int) Math.floor(Math.sqrt(b));

        int first = floorA * floorA < a ? floorA + 1 : floorA;
        int last = floorB;

        if (last >= first) {
            return last - first + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(squares(3, 9)); // 2
        System.out.println(squares(17, 24)); // 0
        System.out.println(squares(24, 24)); // 0
        System.out.println(squares(25, 25)); // 1
    }
}
