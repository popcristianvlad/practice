package com.popcristianvlad.leetcode.practice;

public class P01TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] sum1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(sum1[0] + " " + sum1[1]);


        int[] sum2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(sum2[0] + " " + sum2[1]);
    }
}
