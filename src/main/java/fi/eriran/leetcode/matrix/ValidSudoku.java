package fi.eriran.leetcode.matrix;

public class ValidSudoku {

    private static final char EMPTY = '.';
    private int squareSize;

    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        squareSize = board.length / 3;
        //Brute force: validate row by row, column by column, square by square
        return isValidRowByRow(board)
                && isValidColumnByColumn(board)
                && isValidBySquares(board);
    }

    private boolean isValidRowByRow(char[][] board) {
        for (char[] row : board) {
            Integer[] foundNumbers = new Integer[board.length];
            for (int x = 0; x < board.length; x++) {
                char currentChar = row[x];
                if (currentChar != EMPTY) {
                    int newNumberValue = Character.getNumericValue(currentChar) - 1;
                    Integer foundNumber = foundNumbers[newNumberValue];
                    if (foundNumber != null && foundNumber == newNumberValue) {
                        return false;
                    }
                    foundNumbers[newNumberValue] = newNumberValue;
                }
            }
        }
        return true;
    }

    private boolean isValidColumnByColumn(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            Integer[] foundNumbers = new Integer[board.length];
            for (char[] column : board) {
                char currentChar = column[x];
                if (currentChar != EMPTY) {
                    int newNumberValue = Character.getNumericValue(currentChar) - 1;
                    Integer foundNumber = foundNumbers[newNumberValue];
                    if (foundNumber != null && foundNumber == newNumberValue) {
                        return false;
                    }
                    foundNumbers[newNumberValue] = newNumberValue;
                }
            }
        }
        return true;
    }

    private boolean isValidBySquares(char[][] board) {
        for (int xIncrement = 0; xIncrement < board.length; xIncrement += squareSize) {
            for (int yIncrement = 0; yIncrement < board.length; yIncrement += squareSize) {
                if (!isSquareValid(board, xIncrement, yIncrement)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSquareValid(char[][] board, int xIncrement, int yIncrement) {
        Integer[] foundNumbers = new Integer[board.length];
        for (int x = 0; x < squareSize; x++) {
            for (int y = 0; y < squareSize; y++) {
                char currentChar = board[x + xIncrement][y + yIncrement];
                if (currentChar != EMPTY) {
                    int newNumberValue = Character.getNumericValue(currentChar) - 1;
                    Integer foundNumber = foundNumbers[newNumberValue];
                    if (foundNumber != null && foundNumber == newNumberValue) {
                        return false;
                    }
                    foundNumbers[newNumberValue] = newNumberValue;
                }
            }
        }
        return true;
    }
}
