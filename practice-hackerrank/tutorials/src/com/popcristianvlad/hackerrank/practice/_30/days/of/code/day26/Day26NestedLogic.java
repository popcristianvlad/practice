package com.popcristianvlad.hackerrank.practice._30.days.of.code.day26;

import java.time.LocalDate;
import java.util.Scanner;

public class Day26NestedLogic {

    public static int calculateFine(LocalDate returnDate, LocalDate expectDate) {
        if (returnDate.equals(expectDate) || returnDate.isBefore(expectDate)) {
            return 0;
        }

        if (returnDate.getMonth() == expectDate.getMonth() && returnDate.getYear() == expectDate.getYear()) {
            return 15 * (returnDate.getDayOfMonth() - expectDate.getDayOfMonth());
        }

        if (returnDate.getYear() == expectDate.getYear()) {
            return 500 * (returnDate.getMonthValue() - expectDate.getMonthValue());
        }

        return 10000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int returnDay = sc.nextInt();
        int returnMonth = sc.nextInt();
        int returnYear = sc.nextInt();

        int expectDay = sc.nextInt();
        int expectMonth = sc.nextInt();
        int expectYear = sc.nextInt();

        LocalDate returnDate = LocalDate.of(returnYear, returnMonth, returnDay);
        LocalDate expectDate = LocalDate.of(expectYear, expectMonth, expectDay);

        System.out.println(calculateFine(returnDate, expectDate));
    }
}
