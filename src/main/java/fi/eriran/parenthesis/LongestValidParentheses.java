package fi.eriran.parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 */
public class LongestValidParentheses {

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';

    public int longestValidParentheses(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        validateAllCharactersAreValid(string);
        return countValidParentheses(string);
    }

    private int countValidParentheses(String string) {
        int maxValidParentheses = 0;
        int currentValidParentheses = 0;
        Deque<OpenParenthesisPoint> openParenthesisLocations = new ArrayDeque<>();
        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char currentCharacter = charArray[i];
            if (openParenthesisLocations.isEmpty()) {
                if (currentCharacter == OPEN_PARENTHESIS) {
                    openParenthesisLocations.push(new OpenParenthesisPoint(i, 0));
                } else {
                    maxValidParentheses = attemptToChangeMaxValidLength(currentValidParentheses, maxValidParentheses);
                    currentValidParentheses = 0;
                }
            } else {
                if (currentCharacter == OPEN_PARENTHESIS) {
                    openParenthesisLocations.push(new OpenParenthesisPoint(i, 0));
                } else {
                    OpenParenthesisPoint popped = openParenthesisLocations.pop();
                    if (openParenthesisLocations.isEmpty()) {
                        currentValidParentheses += popped.validAmountAtIndex + 1;
                    } else {
                        openParenthesisLocations.peek().validAmountAtIndex += popped.validAmountAtIndex + 1;
                    }
                }
            }
        }

        if (!openParenthesisLocations.isEmpty()) {
            for (OpenParenthesisPoint openParenthesisLocation : openParenthesisLocations) {
                maxValidParentheses = attemptToChangeMaxValidLength(
                        openParenthesisLocation.validAmountAtIndex,
                        maxValidParentheses
                );
            }
        }
        if (currentValidParentheses != 0) {
            maxValidParentheses = attemptToChangeMaxValidLength(
                    currentValidParentheses,
                    maxValidParentheses);
        }
        return maxValidParentheses * 2;
    }

    private int attemptToChangeMaxValidLength(int currentValidLength, int maxValidLength) {
        return Math.max(currentValidLength, maxValidLength);
    }

    private void validateAllCharactersAreValid(String string) {
        for (char character : string.toCharArray()) {
            if (!isValidCharacter(character)) {
                throw new IllegalArgumentException("Encountered illegal character: " + character);
            }
        }
    }

    public static boolean isValidCharacter(Character character) {
        switch (character) {
            case OPEN_PARENTHESIS:
            case CLOSE_PARENTHESIS:
                return true;
            default:
                return false;
        }
    }

    static class OpenParenthesisPoint {
        int index;
        int validAmountAtIndex;

        public OpenParenthesisPoint(int index, int validAmountAtIndex) {
            this.index = index;
            this.validAmountAtIndex = validAmountAtIndex;
        }
    }
}
