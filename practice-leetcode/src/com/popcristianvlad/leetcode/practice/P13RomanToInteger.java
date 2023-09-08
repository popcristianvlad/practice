package com.popcristianvlad.leetcode.practice;

public class P13RomanToInteger {

    public static int romanToInt(String s) {
        int number = 0;
        char[] romanDigit = s.toCharArray();

        for (int i = 0; i < romanDigit.length; i++) {
            if (romanDigit[i] == 'M') {
                number += 1000;
            }
            if (romanDigit[i] == 'D') {
                number += 500;
            }
            if (romanDigit[i] == 'C') {
                if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'D') {
                    number += 400;
                    i++;
                } else if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'M') {
                    number += 900;
                    i++;
                } else {
                    number += 100;
                }
            }
            if (romanDigit[i] == 'L') {
                number += 50;
            }
            if (romanDigit[i] == 'X') {
                if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'L') {
                    number += 40;
                    i++;
                } else if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'C') {
                    number += 90;
                    i++;
                } else {
                    number += 10;
                }
            }
            if (romanDigit[i] == 'V') {
                number += 5;
            }
            if (romanDigit[i] == 'I') {
                if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'V') {
                    number += 4;
                    i++;
                } else if (i != romanDigit.length - 1 && romanDigit[i + 1] == 'X') {
                    number += 9;
                    i++;
                } else {
                    number += 1;
                }
            }
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III") == 3);
        System.out.println(romanToInt("LVIII") == 58);
        System.out.println(romanToInt("MCMXCIV") == 1994);
    }
}
