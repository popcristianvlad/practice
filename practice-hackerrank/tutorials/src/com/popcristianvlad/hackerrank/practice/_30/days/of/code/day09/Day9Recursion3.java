package com.popcristianvlad.hackerrank.practice._30.days.of.code.day09;

import java.io.*;

class Result2 {

    public static int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        }

        return 1;
    }
}

public class Day9Recursion3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result2.factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
