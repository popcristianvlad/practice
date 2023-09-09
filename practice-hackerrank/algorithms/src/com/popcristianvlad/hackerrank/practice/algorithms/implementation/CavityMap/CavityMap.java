package com.popcristianvlad.hackerrank.practice.algorithms.implementation.CavityMap;

public class CavityMap {

    static String[] cavityMap(String[] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid.length > 0 ? grid[0].length() : 0;

        int[][] gridWithIntegers = new int[numberOfRows][numberOfColumns];
        char[][] gridWithCharacters = new char[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            char[] gridRow = grid[i].toCharArray();
            for (int j = 0; j < numberOfColumns; j++) {
                gridWithIntegers[i][j] = Character.getNumericValue(gridRow[j]);
                gridWithCharacters[i][j] = gridRow[j];
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (i == 0 || j == 0 || i == numberOfRows - 1 || j == numberOfColumns - 1) {
                    // do nothing: edge
                } else {
                    if (gridWithIntegers[i][j] > gridWithIntegers[i - 1][j]
                            && gridWithIntegers[i][j] > gridWithIntegers[i + 1][j]
                            && gridWithIntegers[i][j] > gridWithIntegers[i][j - 1]
                            && gridWithIntegers[i][j] > gridWithIntegers[i][j + 1]) {
                        gridWithCharacters[i][j] = 'X';
                    }
                }
            }
        }

        String[] outputGrid = new String[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < numberOfColumns; j++) {
                sb.append(gridWithCharacters[i][j]);
            }
            outputGrid[i] = sb.toString();
        }

        return outputGrid;
    }

    public static void main(String[] args) {
        int n = 4;

        String[] grid = new String[n];
        grid[0] = "1112";
        grid[1] = "1912";
        grid[2] = "1892";
        grid[3] = "1234";

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
