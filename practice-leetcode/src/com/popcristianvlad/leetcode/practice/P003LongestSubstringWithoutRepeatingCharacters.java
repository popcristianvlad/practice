package com.popcristianvlad.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class P03LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        int longestSubstringLength = 0;
        int currentSubstringLength = 0;
        int startingPosition = 0;
        Map<Character, Integer> currentPositions = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Integer currPos = currentPositions.get(array[i]);
            if (currPos == null || currPos < startingPosition) {
                currentSubstringLength++;
                currentPositions.put(array[i], i);
                longestSubstringLength = longestSubstringLength < currentSubstringLength ? currentSubstringLength : longestSubstringLength;
            } else {
                startingPosition = currPos;
                currentSubstringLength = i - currPos;
                currentPositions.put(array[i], i);
                longestSubstringLength = longestSubstringLength < currentSubstringLength ? currentSubstringLength : longestSubstringLength;
            }
        }

        return longestSubstringLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
