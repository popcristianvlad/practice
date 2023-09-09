package com.popcristianvlad.hackerrank.practice.algorithms.implementation.CountingValleys;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int currentAltitude = 0;
        int valliesEntered = 0;

        for (char step : s.toCharArray()) {
            int initialAltitude = currentAltitude;

            if (step == 'U') {
                currentAltitude++;
            }

            if (step == 'D') {
                currentAltitude--;
            }

            if (currentAltitude < 0 && initialAltitude == 0) {
                valliesEntered++;
            }
        }

        return valliesEntered;
    }

    public static void main(String[] args) {
        int n = 8;
        String s = "DDUUUUDD";
        int result = countingValleys(n, s);
        System.out.println(result);

        System.out.println();

        n = 8;
        s = "UDDDUDUU";
        result = countingValleys(n, s);
        System.out.println(result);
    }
}
