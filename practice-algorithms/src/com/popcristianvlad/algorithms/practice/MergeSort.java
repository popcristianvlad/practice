package com.popcristianvlad.algorithms.practice;

public class MergeSort {

    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int infinity = Integer.MAX_VALUE;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[middle + i + 1];
        }

        L[n1] = infinity;
        R[n2] = infinity;

        int i = 0;
        int j = 0;

        for (int k = left; k <= right; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
        }
    }

    private static void printArray(int[] array) {
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] v = new int[]{0, 5, -3, 59, 9, 1594, 320, 780, 45, 108, 2016, 40, 18, 2, 90, -12, 37, -9, 140, 1};
        mergeSort(v);
        printArray(v);
    }
}
