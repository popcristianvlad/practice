package com.popcristianvlad.hackerrank.practice.java.strings.JavaSubstringComparisons;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 1; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }
            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
}
