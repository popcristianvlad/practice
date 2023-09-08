package com.popcristianvlad.leetcode.practice;

public class P09PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int numberInNormalForm = x;
        int numberInReverseForm = 0;

        while (numberInNormalForm > 0) {
            numberInReverseForm = numberInReverseForm * 10 + numberInNormalForm % 10;
            numberInNormalForm /= 10;
        }

        return x == numberInReverseForm;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
