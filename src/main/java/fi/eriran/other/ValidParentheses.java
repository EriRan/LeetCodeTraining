package fi.eriran.other;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    private static final char OPEN_PARANTHESIS = '(';
    private static final char CLOSE_PARANTHESIS = ')';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char OPEN_CURLY_BRACE = '{';
    private static final char CLOSE_CURLY_BRACE  = '}';

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        else if ("".equals(s)) {
            return true;
        }
        validateHasOnlyValidCharacters(s);
        return iterateString(s);
    }

    private void validateHasOnlyValidCharacters(String s) {
        for (char c : s.toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new IllegalArgumentException("Invalid character encountered: " + c);
            }
        }
    }

    private boolean iterateString(String s) {
        Deque<Character> deque = new ArrayDeque();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                if (isCloseBracket(c)) {
                    return false;
                }
                deque.add(c);
            } else {
                Character topCharacter = deque.peek();

            }
        }
        //todo: change this to true once you are confident that it might work
        return false;
    }

    private boolean isCloseBracket(char c) {
        switch (c) {
            case CLOSE_PARANTHESIS:
            case CLOSE_SQUARE_BRACKET:
            case CLOSE_CURLY_BRACE:
                return true;
            default:
                return false;
        }
    }

    private boolean isValidCharacter(char c) {
        switch (c) {
            case OPEN_PARANTHESIS:
            case OPEN_SQUARE_BRACKET:
            case OPEN_CURLY_BRACE:
            case CLOSE_PARANTHESIS:
            case CLOSE_SQUARE_BRACKET:
            case CLOSE_CURLY_BRACE:
                return true;
            default:
                return false;
        }
    }
}
