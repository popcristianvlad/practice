package com.popcristianvlad.hackerrank.practice.java.introduction.JavaEndOfFile;

import java.util.*;

public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (sc.hasNext()) {
            System.out.println(i++ + " " + sc.nextLine());
        }

        sc.close();
    }
}
