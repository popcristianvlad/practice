package com.popcristianvlad.hackerrank.practice.algorithms.implementation.MatrixLayerRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixLayerRotation {

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int numberOfRows = matrix.size();
        int numberOfColumns = matrix.get(0).size();

        List<List<Integer>> flattenMatrix = flatMatrix(matrix);
        flattenMatrix.forEach(row -> rotateRow(row, r));
        List<List<Integer>> unflattenMatrix = unflatMatrix(flattenMatrix, numberOfRows, numberOfColumns);
        printMatrix(unflattenMatrix);
    }

    /**
     * to flat = extract concentric circles, from outside to inside
     */
    static List<List<Integer>> flatMatrix(List<List<Integer>> unflattenMatrix) {
        int numberOfRows = unflattenMatrix.size();
        int numberOfColumns = unflattenMatrix.get(0).size();
        int numberOfFlattenRows = findNumberOfFlattenRows(numberOfRows, numberOfColumns);

        List<List<Integer>> flattenMatrix = new ArrayList<>();

        for (int k = 0; k < numberOfFlattenRows; k++) {
            List<Integer> row = new ArrayList<>();

            for (int i = k; i < numberOfColumns - k; i++) {
                row.add(unflattenMatrix.get(k).get(i));
            }

            for (int i = k + 1; i < numberOfRows - k; i++) {
                row.add(unflattenMatrix.get(i).get(numberOfColumns - 1 - k));
            }

            for (int i = numberOfColumns - 1 - k - 1; i >= k; i--) {
                row.add(unflattenMatrix.get(numberOfRows - 1 - k).get(i));
            }

            for (int i = numberOfRows - 1 - k - 1; i > k; i--) {
                row.add(unflattenMatrix.get(i).get(k));
            }

            flattenMatrix.add(row);
        }

        return flattenMatrix;
    }

    static int findNumberOfFlattenRows(int numberOfRows, int numberOfColumns) {
        int minimum = numberOfRows < numberOfColumns ? numberOfRows : numberOfColumns;
        return minimum % 2 == 0 ? minimum / 2 : (minimum / 2) + 1;
    }

    static void rotateRow(List<Integer> row, int times) {
        int size = row.size();
        List<Integer> removedElements = new ArrayList<>();
        for (int i = 0; i < times % size; i++) {
            removedElements.add(row.remove(0));
        }

        row.addAll(removedElements);
    }

    static List<List<Integer>> unflatMatrix(List<List<Integer>> flattenMatrix, int numberOfRows, int numberOfColumns) {
        List<List<Integer>> unflattenMatrix = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < numberOfColumns; j++) {
                row.add(0);
            }
            unflattenMatrix.add(row);
        }

        int numberOfFlattenRows = flattenMatrix.size();

        for (int k = 0; k < numberOfFlattenRows; k++) {
            List<Integer> row = new ArrayList<>();
            int r = 0;

            for (int i = k; i < numberOfColumns - k; i++) {
                unflattenMatrix.get(k).set(i, flattenMatrix.get(k).get(r++));
            }

            for (int i = k + 1; i < numberOfRows - k; i++) {
                unflattenMatrix.get(i).set(numberOfColumns - 1 - k, flattenMatrix.get(k).get(r++));
            }

            for (int i = numberOfColumns - 1 - k - 1; i >= k; i--) {
                unflattenMatrix.get(numberOfRows - 1 - k).set(i, flattenMatrix.get(k).get(r++));
            }

            for (int i = numberOfRows - 1 - k - 1; i > k; i--) {
                unflattenMatrix.get(i).set(k, flattenMatrix.get(k).get(r++));
            }
        }

        return unflattenMatrix;
    }

    static void printMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> {
            row.forEach(element -> System.out.print(element + " "));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(12, 1, 2, 5));
        matrix.add(Arrays.asList(11, 4, 3, 6));
        matrix.add(Arrays.asList(10, 9, 8, 7));

        matrixRotation(matrix, 2);

        System.out.println();
        System.out.println();

        List<List<Integer>> matrix2 = new ArrayList<>();
        matrix2.add(Arrays.asList(1, 2, 3, 4));
        matrix2.add(Arrays.asList(7, 8, 9, 10));
        matrix2.add(Arrays.asList(13, 14, 15, 16));
        matrix2.add(Arrays.asList(19, 20, 21, 22));
        matrix2.add(Arrays.asList(25, 26, 27, 28));

        matrixRotation(matrix2, 7);
    }
}
