package com.popcristianvlad.hackerrank.practice._30.days.of.code.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day10BinaryNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        char[] bits = Integer.toBinaryString(n).toCharArray();

        int maxNumberOf1s = 0;
        int currentNumberOf1s = 0;

        for (char bit : bits) {
            if (bit == '1') {
                currentNumberOf1s++;
                if (currentNumberOf1s > maxNumberOf1s) {
                    maxNumberOf1s = currentNumberOf1s;
                }
            } else {
                currentNumberOf1s = 0;
            }
        }

        System.out.println(maxNumberOf1s);

        bufferedReader.close();
    }
}
