package com.popcristianvlad.hackerrank.practice.algorithms.implementation.TheBombermanGame;

public class TheBombermanGame {

    static String[] bomberMan(int n, String[] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid.length > 0 ? grid[0].length() : 0;

        if (n == 0 || n == 1) {
            return grid;
        }

        if (n % 2 == 0) {
            return createFullBombGrid(numberOfRows, numberOfColumns);
        }

        int[][] flowAt0 = transformToNumberedGrid(grid, numberOfRows, numberOfColumns);
        int[][] flowAt1 = doNothing(flowAt0, numberOfRows, numberOfColumns);
        int[][] flowAt2 = plantBombs(flowAt1, numberOfRows, numberOfColumns);
        int[][] flowAt3 = explodeBombs(flowAt2, numberOfRows, numberOfColumns);
        int[][] flowAt4 = plantBombs(flowAt3, numberOfRows, numberOfColumns);
        int[][] flowAt5 = explodeBombs(flowAt4, numberOfRows, numberOfColumns);

        if (n % 4 == 1) {
            return transformToStringGrid(flowAt5, numberOfRows, numberOfColumns);
        } else {
            // n % 4 == 3
            return transformToStringGrid(flowAt3, numberOfRows, numberOfColumns);
        }
    }

    private static int[][] doNothing(int[][] numberedGrid, int numberOfRows, int numberOfColumns) {
        int[][] outputGrid = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (numberedGrid[i][j] == 3) {
                    outputGrid[i][j] = 2;
                } else {
                    // numberedGrid[i][j] == 0
                    outputGrid[i][j] = 0;
                }
            }
        }

        return outputGrid;
    }

    private static int[][] plantBombs(int[][] numberedGrid, int numberOfRows, int numberOfColumns) {
        int[][] outputGrid = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (numberedGrid[i][j] == 0) {
                    outputGrid[i][j] = 3;
                } else {
                    // numberedGrid[i][j] == 2
                    outputGrid[i][j] = 1;
                }
            }
        }

        return outputGrid;
    }

    private static int[][] explodeBombs(int[][] numberedGrid, int numberOfRows, int numberOfColumns) {
        int[][] outputGrid = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                outputGrid[i][j] = numberedGrid[i][j];
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (outputGrid[i][j] == 1) {
                    outputGrid[i][j] = 0;
                    explodeAt(outputGrid, i - 1, j, numberOfRows, numberOfColumns);
                    explodeAt(outputGrid, i + 1, j, numberOfRows, numberOfColumns);
                    explodeAt(outputGrid, i, j - 1, numberOfRows, numberOfColumns);
                    explodeAt(outputGrid, i, j + 1, numberOfRows, numberOfColumns);
                }
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (outputGrid[i][j] == 3) {
                    outputGrid[i][j] = 2;
                }
            }
        }

        return outputGrid;
    }

    private static void explodeAt(int[][] numberedGrid, int i, int j, int numberOfRows, int numberOfColumns) {
        if (i < 0 || j < 0 || i >= numberOfRows || j >= numberOfColumns) {
            // do nothing
        } else {
            if (numberedGrid[i][j] == 3) {
                numberedGrid[i][j] = 0;
            }
        }
    }

    static int[][] transformToNumberedGrid(String[] grid, int numberOfRows, int numberOfColumns) {
        int[][] numberedGrid = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            char[] gridRow = grid[i].toCharArray();
            for (int j = 0; j < numberOfColumns; j++) {
                numberedGrid[i][j] = gridRow[j] == '.' ? 0 : 3;
            }
        }

        return numberedGrid;
    }

    static String[] createFullBombGrid(int numberOfRows, int numberOfColumns) {
        String[] grid = new String[numberOfRows];

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numberOfColumns; j++) {
            sb.append('O');
        }

        String line = sb.toString();

        for (int i = 0; i < numberOfRows; i++) {
            grid[i] = line;
        }

        return grid;
    }

    static String[] transformToStringGrid(int[][] numberedGrid, int numberOfRows, int numberOfColumns) {
        String[] grid = new String[numberOfRows];

        for (int i = 0; i < numberOfRows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < numberOfColumns; j++) {
                sb.append(numberedGrid[i][j] == 0 ? '.' : 'O');
            }
            grid[i] = sb.toString();
        }

        return grid;
    }

    public static void main(String[] args) {
        int r = 6;
        int c = 7;
        int n = 3;

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }
    }
}
