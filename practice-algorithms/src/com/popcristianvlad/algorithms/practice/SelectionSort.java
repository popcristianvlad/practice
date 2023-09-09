package com.popcristianvlad.algorithms.practice;

public class SelectionSort {

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int to_swap = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[to_swap]) {
                    to_swap = j;
                }
            }
            int temp = arr[to_swap];
            arr[to_swap] = arr[i];
            arr[i] = temp;
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
        selectionSort(v);
        printArray(v);
    }
}
