package com.popcristianvlad.hackerrank.practice.java.introduction.JavaStaticInitializerBlock;

import java.util.*;

public class JavaStaticInitializerBlock {

    private final static Scanner scanner = new Scanner(System.in);
    private final static int B = scanner.nextInt();
    private final static int H = scanner.nextInt();
    private final static boolean flag;

    static {
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}