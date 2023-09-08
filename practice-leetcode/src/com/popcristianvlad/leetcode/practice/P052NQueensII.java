package com.popcristianvlad.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class P52NQueensII {

    class Queen {
        int row;
        int column;

        Queen(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int totalNQueens(int n) {
        return solveNQueensProblem(n, new ArrayList<>(), 0);
    }

    private int solveNQueensProblem(int n, List<Queen> queensSoFar, int newQueenDepth) {
        int solutions = 0;

        for (int i = 0; i < n; i++) {
            Queen queenToCheck = new Queen(newQueenDepth, i);
            if (isQueenValid(queensSoFar, queenToCheck)) {
                if (newQueenDepth == n - 1) {
                    solutions++;
                } else {
                    queensSoFar.add(queenToCheck);
                    solutions += solveNQueensProblem(n, queensSoFar, newQueenDepth + 1);
                    queensSoFar.remove(queenToCheck);
                }
            }
        }

        return solutions;
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

    public static void main(String[] args) {
        System.out.println(new P52NQueensII().totalNQueens(4));
        System.out.println(new P52NQueensII().totalNQueens(1));
    }
}
