package com.popcristianvlad.hackerrank.practice.algorithms.strings.StrongPassword;

public class StrongPassword {

    private static int minimum_length = 6;

    private static String numbers = "0123456789";
    private static String lower_case = "abcdefghijklmnopqrstuvwxyz";
    private static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String special_characters = "!@#$%^&*()-+";

    static int minimumNumber(int n, String password) {
        int missingCharacters = 0;

        missingCharacters += computeMissing(password, numbers);
        missingCharacters += computeMissing(password, lower_case);
        missingCharacters += computeMissing(password, upper_case);
        missingCharacters += computeMissing(password, special_characters);

        if (n + missingCharacters < minimum_length) {
            return minimum_length - n;
        }

        return missingCharacters;

    }

    static int computeMissing(String str1, String charsString) {
        char[] chars = charsString.toCharArray();
        for (char c : chars) {
            if (str1.contains(c + "")) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(3, "Ab1"));
        System.out.println(minimumNumber(11, "#HackerRank"));
    }
}
