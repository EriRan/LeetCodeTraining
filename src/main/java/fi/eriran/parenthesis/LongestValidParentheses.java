package fi.eriran.parenthesis;

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
        int maxValidLength = 0;
        int currentValidLength = 0;
        Character previousCharacter = null;

        for (char currentCharacter : string.toCharArray()) {
            if (previousCharacter == null) {
                previousCharacter = currentCharacter;
            } else {
                if (previousCharacter == CLOSE_PARENTHESIS) {
                    if (currentCharacter != OPEN_PARENTHESIS) {
                        maxValidLength = attemptToChangeMaxValidLength(currentValidLength, maxValidLength);
                        currentValidLength = 0;
                    }
                } else if (previousCharacter == OPEN_PARENTHESIS) {
                    if (currentCharacter == CLOSE_PARENTHESIS) {
                        currentValidLength += 2;
                    } else {
                        maxValidLength = attemptToChangeMaxValidLength(currentValidLength, maxValidLength);
                        currentValidLength = 0;
                    }
                }
                previousCharacter = currentCharacter;
            }
        }
        if (currentValidLength != 0) {
            maxValidLength = attemptToChangeMaxValidLength(currentValidLength, maxValidLength);
        }
        return maxValidLength;
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
