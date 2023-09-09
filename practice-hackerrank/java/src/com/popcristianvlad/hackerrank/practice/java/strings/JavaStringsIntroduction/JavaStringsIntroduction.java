package com.popcristianvlad.hackerrank.practice.java.strings.JavaStringsIntroduction;

import java.util.*;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println((A.length() > 0 ? (A.charAt(0) + "").toUpperCase() + A.substring(1) : A) + " " +
                (B.length() > 0 ? (B.charAt(0) + "").toUpperCase() + B.substring(1) : B));
    }
}
