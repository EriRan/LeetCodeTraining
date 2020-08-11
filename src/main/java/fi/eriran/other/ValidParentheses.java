package fi.eriran.other;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';
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
        Deque<Character> deque = new ArrayDeque<>();
        for (char currentCharacter : s.toCharArray()) {
            if (deque.isEmpty()) {
                if (isCloseBracket(currentCharacter)) {
                    return false;
                }
                deque.add(currentCharacter);
            } else {
                if (isOpenBracket(currentCharacter)) {
                    deque.push(currentCharacter);
                } else {
                    Character topCharacter = deque.pop();
                    if (!isCorrectBracketClosed(topCharacter, currentCharacter)) {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }

    private boolean isCorrectBracketClosed(Character topCharacter, char currentCharacter) {
        switch (topCharacter) {
            case OPEN_PARENTHESIS:
                if (currentCharacter == CLOSE_PARENTHESIS) {
                    return true;
                }
                break;
            case OPEN_SQUARE_BRACKET:
                if (currentCharacter == CLOSE_SQUARE_BRACKET) {
                    return true;
                }
                break;
            case OPEN_CURLY_BRACE:
                if (currentCharacter == CLOSE_CURLY_BRACE) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    private boolean isCloseBracket(char c) {
        switch (c) {
            case CLOSE_PARENTHESIS:
            case CLOSE_SQUARE_BRACKET:
            case CLOSE_CURLY_BRACE:
                return true;
            default:
                return false;
        }
    }

    private boolean isOpenBracket(char c) {
        switch (c) {
            case OPEN_PARENTHESIS:
            case OPEN_SQUARE_BRACKET:
            case OPEN_CURLY_BRACE:
                return true;
            default:
                return false;
        }
    }

    private boolean isValidCharacter(char c) {
        switch (c) {
            case OPEN_PARENTHESIS:
            case OPEN_SQUARE_BRACKET:
            case OPEN_CURLY_BRACE:
            case CLOSE_PARENTHESIS:
            case CLOSE_SQUARE_BRACKET:
            case CLOSE_CURLY_BRACE:
                return true;
            default:
                return false;
        }
    }
}
