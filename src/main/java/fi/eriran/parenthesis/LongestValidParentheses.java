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
        return 0;
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
