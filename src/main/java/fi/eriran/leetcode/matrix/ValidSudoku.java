package fi.eriran.leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    private static final char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        //Brute force: validate row by row, column by column, square by square
        return isValidRowByRow(board)
                && isValidColumnByColumn(board)
                && isValidBySquares(board);
    }

    private boolean isValidRowByRow(char[][] board) {
        for (char[] row : board) {
            Set<Character> foundNumbers = new HashSet<>();
            for (int x = 0; x < board.length; x++) {
                char currentChar = row[x];
                if (currentChar != EMPTY && !foundNumbers.add(currentChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidColumnByColumn(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            Set<Character> foundNumbers = new HashSet<>();
            for (char[] column : board) {
                char currentChar = column[x];
                if (currentChar != EMPTY && !foundNumbers.add(currentChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBySquares(char[][] board) {
        //todo: implement
        return false;
    }
}
