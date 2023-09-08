package com.popcristianvlad.leetcode.practice;

public class P14LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int numberOfStrings = strs.length;

        if (numberOfStrings == 1) {
            return strs[0];
        }

        int currentPosToCheck = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (strs[0].length() == currentPosToCheck) {
                return sb.toString();
            }

            char firstLetter = strs[0].charAt(currentPosToCheck);
            for (int i = 1; i < numberOfStrings; i++) {
                if (strs[i].length() == currentPosToCheck || firstLetter != strs[i].charAt(currentPosToCheck)) {
                    return sb.toString();
                }
            }

            sb.append(firstLetter);
            currentPosToCheck++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl"));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals(""));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}).equals("a"));
    }
}
