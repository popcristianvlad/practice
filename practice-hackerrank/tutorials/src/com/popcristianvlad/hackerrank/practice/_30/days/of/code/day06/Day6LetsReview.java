package com.popcristianvlad.hackerrank.practice._30.days.of.code.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6LetsReview {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        scanner.nextLine();

        List<String> stringList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            stringList.add(scanner.nextLine());
        }

        for (String s : stringList) {
            int length = s.length();
            for (int j = 0; j < length; j++) {
                if (j % 2 == 0) {
                    System.out.print(s.charAt(j));
                }
            }

            System.out.print(" ");

            for (int j = 0; j < length; j++) {
                if (j % 2 == 1) {
                    System.out.print(s.charAt(j));
                }
            }

            System.out.println();
        }
    }
}
