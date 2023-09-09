package com.popcristianvlad.hackerrank.practice.algorithms.implementation.ElectronicsShop;

public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int moneyToSpend = -1;

        for (int keyboardPrice : keyboards) {
            for (int drivePrive : drives) {
                int combinedPrice = keyboardPrice + drivePrive;
                if (combinedPrice <= b && combinedPrice > moneyToSpend) {
                    moneyToSpend = combinedPrice;
                }
            }
        }

        return moneyToSpend;
    }

    public static void main(String[] args) {
        int b = 10;
        int n = 2;
        int m = 3;
        int[] keyboards = new int[]{3, 1}; // n elements
        int[] drives = new int[]{5, 2, 8}; // m elements
        int moneySpent = getMoneySpent(keyboards, drives, b);
        System.out.println(moneySpent);

        b = 5;
        n = 1;
        m = 1;
        keyboards = new int[]{4}; // n elements
        drives = new int[]{5}; // m elements
        moneySpent = getMoneySpent(keyboards, drives, b);
        System.out.println(moneySpent);
    }
}
