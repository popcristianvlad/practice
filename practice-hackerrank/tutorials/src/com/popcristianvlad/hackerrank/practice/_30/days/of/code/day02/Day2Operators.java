package com.popcristianvlad.hackerrank.practice._30.days.of.code.day02;

import java.io.*;

class Result {

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        System.out.println(Math.round(meal_cost + 0.01 * tip_percent * meal_cost + 0.01 * tax_percent * meal_cost));
    }
}

public class Day2Operators {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}
