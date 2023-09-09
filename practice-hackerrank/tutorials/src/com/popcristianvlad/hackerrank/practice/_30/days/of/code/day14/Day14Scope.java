package com.popcristianvlad.hackerrank.practice._30.days.of.code.day14;

import java.util.Scanner;

class Difference {

    private int[] elements;
    public int maximumDifference;

    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                int absoluteValue = Math.abs(elements[i] - elements[j]);
                maximumDifference = maximumDifference > absoluteValue ? maximumDifference : absoluteValue;
            }
        }
    }
}

public class Day14Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
