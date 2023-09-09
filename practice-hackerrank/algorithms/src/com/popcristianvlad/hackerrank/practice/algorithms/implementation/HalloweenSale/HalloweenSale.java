package com.popcristianvlad.hackerrank.practice.algorithms.implementation.HalloweenSale;

public class HalloweenSale {

    static int howManyGames(int p, int d, int m, int s) {
        int itemsPurchased = 0;
        int partialSum = p;

        while (partialSum <= s) {
            itemsPurchased++;
            p = (p - d) > m ? p - d : m;
            partialSum += p;
        }

        return itemsPurchased++;
    }

    public static void main(String[] args) {
        int p = 20;
        int d = 3;
        int m = 6;
        int s = 80;
        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);

        p = 20;
        d = 3;
        m = 6;
        s = 85;
        answer = howManyGames(p, d, m, s);
        System.out.println(answer);

        p = 20;
        d = 3;
        m = 6;
        s = 21;
        answer = howManyGames(p, d, m, s);
        System.out.println(answer);
    }
}
