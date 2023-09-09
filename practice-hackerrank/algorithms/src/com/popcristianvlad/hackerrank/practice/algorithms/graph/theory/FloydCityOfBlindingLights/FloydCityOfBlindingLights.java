package com.popcristianvlad.hackerrank.practice.algorithms.graph.theory.FloydCityOfBlindingLights;

public class FloydCityOfBlindingLights {

    static int[][] generateFloydMatrix(int numberOfNodes, int numberOfEdges, int[] roadFrom, int[] roadTo, int[] roadWeight) {
        int[][] floydMatrix = new int[numberOfNodes][numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if (i == j) {
                    floydMatrix[i][j] = 0;
                } else {
                    floydMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < numberOfEdges; i++) {
            if (roadFrom[i] != roadTo[i]) {
                floydMatrix[roadFrom[i] - 1][roadTo[i] - 1] = roadWeight[i];
            }
        }

        for (int k = 0; k < numberOfNodes; k++) {
            for (int i = 0; i < numberOfNodes; i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    int sum = sum(floydMatrix[i][k], floydMatrix[k][j]);

                    if (sum < floydMatrix[i][j]) {
                        floydMatrix[i][j] = sum;
                    }
                }
            }
        }

        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if (floydMatrix[i][j] == Integer.MAX_VALUE) {
                    floydMatrix[i][j] = -1;
                }
            }
        }

        return floydMatrix;
    }

    static int sum(int a, int b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return a + b;
    }

    static int getWeightForNodes(int[][] floydMatrix, int x, int y) {
        return floydMatrix[x - 1][y - 1];
    }

    public static void main(String[] args) {
        main_hardcodedValues();
    }

    private static void main_hardcodedValues() {
        int numberOfNodes = 4;
        int numberOfEdges = 5;

        int[] roadFrom = new int[]{1, 1, 2, 3, 3};
        int[] roadTo = new int[]{2, 4, 4, 4, 2};
        int[] roadWeight = new int[]{5, 24, 6, 4, 7};

        int[][] floydMatrix = generateFloydMatrix(numberOfNodes, numberOfEdges, roadFrom, roadTo, roadWeight);

        System.out.println(getWeightForNodes(floydMatrix, 1, 2));
        System.out.println(getWeightForNodes(floydMatrix, 3, 1));
        System.out.println(getWeightForNodes(floydMatrix, 1, 4));
    }
}
