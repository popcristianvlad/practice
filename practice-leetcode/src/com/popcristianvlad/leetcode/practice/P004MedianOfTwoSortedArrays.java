package com.popcristianvlad.leetcode.practice;

public class P004MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int lengthSum = nums1Length + nums2Length;
        int toEliminate = lengthSum % 2 == 1 ? lengthSum / 2 : lengthSum / 2 - 1;
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < toEliminate; i++) {
            if (counter1 < nums1Length && counter2 < nums2Length) {
                if (nums1[counter1] <= nums2[counter2]) {
                    counter1++;
                } else {
                    counter2++;
                }
            } else if (counter1 >= nums1Length) {
                counter2++;
            } else {
                counter1++;
            }
        }

        if (lengthSum % 2 == 1) {
            if (counter1 < nums1Length && counter2 < nums2Length) {
                return nums1[counter1] < nums2[counter2] ? nums1[counter1] : nums2[counter2];
            } else if (counter1 >= nums1Length) {
                return nums2[counter2];
            } else {
                return nums1[counter1];
            }
        } else {
            int elem1 = 0;
            int elem2 = 0;

            if (counter1 < nums1Length && counter2 < nums2Length) {
                if (nums1[counter1] < nums2[counter2]) {
                    elem1 = nums1[counter1];
                    counter1++;
                } else {
                    elem1 = nums2[counter2];
                    counter2++;
                }

                if (counter1 < nums1Length && counter2 < nums2Length) {
                    if (nums1[counter1] < nums2[counter2]) {
                        elem2 = nums1[counter1];
                    } else {
                        elem2 = nums2[counter2];
                    }
                } else if (counter1 >= nums1Length) {
                    elem2 = nums2[counter2];
                } else {
                    elem2 = nums1[counter1];
                }

                return (double) (elem1 + elem2) / 2;
            } else if (counter1 >= nums1Length) {
                return (double) (nums2[counter2] + nums2[counter2 + 1]) / 2;
            } else {
                return (double) (nums1[counter1] + nums1[counter1 + 1]) / 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2d);
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5d);
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}) == 0d);
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}) == 1d);
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}) == 2d);

        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{10}) == 5.5d);
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{}) == 5d);

        System.out.println(findMedianSortedArrays(new int[]{10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) == 5.5d);
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) == 5d);
    }
}
