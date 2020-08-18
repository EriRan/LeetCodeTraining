package fi.eriran.leetcode.strings.parenthesis;

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
        //Amount of valid parentheses times two is the amount of valid characters
        return countValidParentheses(string) * 2;
    }

    private int countValidParentheses(String string) {
        if (string.length() == 1) {
            return 0;
        }
        int maxValidParentheses = 0;
        int currentValidParentheses = 0;
        Deque<Integer> openParenthesisValuesAt = new ArrayDeque<>();

        for (char currentCharacter : string.toCharArray()) {
            if (currentCharacter == OPEN_PARENTHESIS) {
                openParenthesisValuesAt.push(0);
            } else if (openParenthesisValuesAt.isEmpty()) {
                //Current character is a closed parenthesis and no unclosed parentheses exist
                //This is guaranteed to be an invalid character so we will attempt to add the currentValidParentheses
                // as max and then reset it
                maxValidParentheses = attemptToChangeMaxValidLength(currentValidParentheses, maxValidParentheses);
                currentValidParentheses = 0;
            } else {
                //Current character is a closed parenthesis and there exist unclosed parentheses
                Integer closedParenthesisValueAt = openParenthesisValuesAt.pop();
                if (openParenthesisValuesAt.isEmpty()) {
                    currentValidParentheses += closedParenthesisValueAt + 1;
                } else {
                    //Increment the top integer of the queue with the valueAt of the closed parenthesis with 1
                    openParenthesisValuesAt.push(closedParenthesisValueAt + openParenthesisValuesAt.pop() + 1);
                }
            }
        }

        return calculatePossibleMaxFromRemaining(
                maxValidParentheses,
                currentValidParentheses,
                openParenthesisValuesAt);
    }

    private int calculatePossibleMaxFromRemaining(int maxValidParentheses,
                                                  int currentValidParentheses,
                                                  Deque<Integer> openParenthesisValuesAt) {
        if (!openParenthesisValuesAt.isEmpty()) {
            for (Integer openParenthesisValueAt : openParenthesisValuesAt) {
                maxValidParentheses = attemptToChangeMaxValidLength(
                        openParenthesisValueAt,
                        maxValidParentheses
                );
            }
        }
        if (currentValidParentheses != 0) {
            maxValidParentheses = attemptToChangeMaxValidLength(
                    currentValidParentheses,
                    maxValidParentheses);
        }
        return maxValidParentheses;
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
}
