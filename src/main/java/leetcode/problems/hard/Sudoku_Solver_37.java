package leetcode.problems.hard;

import java.util.*;

/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class Sudoku_Solver_37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) { // if I can put c in this place
                            board[i][j] = c;
                            if (solve(board)) {
                                // we were able to solve the entire Sudoku recursively
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // we tried everypossibility for this '.' but no success, so return false
                    return false;
                }
            }
        }
        // there were no '.'
        return true;
    }

    boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // check row
            if (board[i][col] == c) return false; // check row
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku_Solver_37 x = new Sudoku_Solver_37();
        char[][] input = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}, 
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        x.solveSudoku(input);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input[i][j]);
                if (j == 8) {
                    System.out.println();
                }
            }
        }
    }

}
