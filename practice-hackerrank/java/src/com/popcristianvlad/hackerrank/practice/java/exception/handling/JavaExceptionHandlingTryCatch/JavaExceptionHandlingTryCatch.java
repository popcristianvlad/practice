package com.popcristianvlad.hackerrank.practice.java.exception.handling.JavaExceptionHandlingTryCatch;

import java.util.*;

public class JavaExceptionHandlingTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a / b);
        } catch (InputMismatchException ex) {
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException ex) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } finally {
            scanner.close();
        }
    }
}
