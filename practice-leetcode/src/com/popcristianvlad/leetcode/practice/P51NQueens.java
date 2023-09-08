package com.popcristianvlad.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class P51NQueens {

    class Queen {
        int row;
        int column;

        Queen(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Queen>> finalValidQueens = new ArrayList<>();
        solveNQueensProblem(n, new ArrayList<>(), 0, finalValidQueens);

        return convert(finalValidQueens, n);
    }

    private void solveNQueensProblem(int n, List<Queen> queensSoFar, int newQueenDepth, List<List<Queen>> finalValidQueens) {
        for (int i = 0; i < n; i++) {
            Queen queenToCheck = new Queen(newQueenDepth, i);
            if (isQueenValid(queensSoFar, queenToCheck)) {
                if (newQueenDepth == n - 1) {
                    queensSoFar.add(queenToCheck);
                    finalValidQueens.add(new ArrayList<>(queensSoFar));
                    queensSoFar.remove(queenToCheck);
                } else {
                    queensSoFar.add(queenToCheck);
                    solveNQueensProblem(n, queensSoFar, newQueenDepth + 1, finalValidQueens);
                    queensSoFar.remove(queenToCheck);
                }
            }
        }
    }

    private boolean isQueenValid(List<Queen> queensSoFar, Queen queenToCheck) {
        for (Queen alreadyExistingQueen : queensSoFar) {
            if ((alreadyExistingQueen.row == queenToCheck.row)
                    || (alreadyExistingQueen.column == queenToCheck.column)
                    || (queenToCheck.row - alreadyExistingQueen.row == queenToCheck.column - alreadyExistingQueen.column)
                    || (queenToCheck.row - alreadyExistingQueen.row == alreadyExistingQueen.column - queenToCheck.column)) {
                return false;
            }
        }

        return true;
    }

    private List<List<String>> convert(List<List<Queen>> queens, int n) {
        List<List<String>> result = new ArrayList<>();

        for (List<Queen> solution : queens) {
            List<String> solutionString = new ArrayList<>();
            for (Queen queen : solution) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= queen.column - 1; i++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int i = queen.column + 1; i < n; i++) {
                    sb.append(".");
                }
                solutionString.add(sb.toString());
            }

            result.add(solutionString);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result1 = new P51NQueens().solveNQueens(4);
        List<List<String>> result2 = new P51NQueens().solveNQueens(1);

        for (List<String> list : result1) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (List<String> list : result2) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
