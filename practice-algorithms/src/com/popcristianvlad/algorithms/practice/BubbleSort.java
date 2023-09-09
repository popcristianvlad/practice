package com.popcristianvlad.algorithms.practice;

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    private static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSortEfficiently(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
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
        int[] v1 = new int[]{0, 5, -3, 59, 9, 1594, 320, 780, 45, 108, 2016, 40, 18, 2, 90, -12, 37, -9, 140, 1};
        int[] v2 = new int[]{0, 5, -3, 59, 9, 1594, 320, 780, 45, 108, 2016, 40, 18, 2, 90, -12, 37, -9, 140, 1};
        int[] v3 = new int[]{0, 5, -3, 59, 9, 1594, 320, 780, 45, 108, 2016, 40, 18, 2, 90, -12, 37, -9, 140, 1};

        bubbleSort(v1);
        bubbleSort2(v2);
        bubbleSortEfficiently(v3);

        printArray(v1);
        printArray(v2);
        printArray(v3);
    }
}
