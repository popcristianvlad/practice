package com.popcristianvlad.hackerrank.practice.algorithms.implementation.DrawingBook;

public class DrawingBook {

    static int pageCount(int n, int p) {
        if (p == 1) {
            return 0;
        }

        int leftPageNumber = p % 2 == 0 ? p : p - 1;

        int posibility1 = leftPageNumber / 2;
        int posibility2 = (n - leftPageNumber) / 2;

        return Math.min(posibility1, posibility2);
    }

    public static void main(String[] args) {
        int n = 6;
        int p = 2;
        int result = pageCount(n, p);
        System.out.println(result);

        n = 5;
        p = 4;
        result = pageCount(n, p);
        System.out.println(result);
    }
}
