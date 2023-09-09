package com.popcristianvlad.hackerrank.practice.java.strings.JavaAnagrams;

import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] appearancesA = new int[26];
        int[] appearancesB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char charA = (a.charAt(i) + "").toUpperCase().charAt(0);
            char charB = (b.charAt(i) + "").toUpperCase().charAt(0);

            appearancesA[charA - 65]++;
            appearancesB[charB - 65]++;
        }

        for (int i = 0; i < 26; i++) {
            if (appearancesA[i] != appearancesB[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
