package com.popcristianvlad.hackerrank.practice.algorithms.implementation.AppendAndDelete;

public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        int lastMatchingPosition = findLastMatchingPosition(s, t);

        int notMatchingCharactersInS = s.length() - (lastMatchingPosition + 1);
        int notMatchingCharactersInT = t.length() - (lastMatchingPosition + 1);
        int minimumNecessaryMoves = notMatchingCharactersInS + notMatchingCharactersInT;

        if (k < minimumNecessaryMoves) {
            return "No";
        }

        if (k == minimumNecessaryMoves) {
            return "Yes";
        }

        // k > minimumNecessaryMoves
        int extraMoves = k - minimumNecessaryMoves;

        if (extraMoves % 2 == 0) {
            return "Yes";
        } else {
            if (extraMoves >= 2 * (lastMatchingPosition + 1)) {
                return "Yes";
            } else {
                return "No";
            }
        }
    }

    static int findLastMatchingPosition(String s, String t) {
        int lastMatchingPosition = -1;

        if (s.isEmpty() || t.isEmpty()) {
            return lastMatchingPosition;
        }

        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        int length1 = a1.length;
        int length2 = a2.length;

        while (lastMatchingPosition < length1 - 1 && lastMatchingPosition < length2 - 1) {
            if (a1[lastMatchingPosition + 1] == a2[lastMatchingPosition + 1]) {
                lastMatchingPosition++;
            } else {
                break;
            }
        }

        return lastMatchingPosition;
    }

    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9)); // Yes
        System.out.println(appendAndDelete("aba", "aba", 7)); // Yes
        System.out.println(appendAndDelete("ashley", "ash", 2)); // No

        System.out.println(appendAndDelete("abc", "ade", 1)); // No
        System.out.println(appendAndDelete("abc", "ade", 2)); // No
        System.out.println(appendAndDelete("abc", "ade", 3)); // No
        System.out.println(appendAndDelete("abc", "ade", 4)); // Yes
        System.out.println(appendAndDelete("abc", "ade", 5)); // No
        System.out.println(appendAndDelete("abc", "ade", 6)); // Yes
        System.out.println(appendAndDelete("abc", "ade", 7)); // Yes
    }
}
