package fi.eriran.leetcode.strings.parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';
    private static final char OPEN_SQUARE_BRACKET = '[';
    private static final char CLOSE_SQUARE_BRACKET = ']';
    private static final char OPEN_CURLY_BRACE = '{';
    private static final char CLOSE_CURLY_BRACE = '}';

    public boolean isValid(String string) {
        if (string == null) {
            return false;
        } else if (string.isEmpty()) {
            return true;
        }
        validateHasOnlyValidCharacters(string);
        return hasCorrectBrackets(string);
    }

    private void validateHasOnlyValidCharacters(String string) {
        for (char character : string.toCharArray()) {
            if (!isValidCharacter(character)) {
                throw new IllegalArgumentException("Invalid character encountered: " + character);
            }
        }
    }

    private boolean hasCorrectBrackets(String string) {
        Deque<Character> openBracketsDeque = new ArrayDeque<>();
        for (char currentCharacter : string.toCharArray()) {
            if (isCharacterValid(openBracketsDeque, currentCharacter)) return false;
        }
        return openBracketsDeque.isEmpty();
    }

    private boolean isCharacterValid(Deque<Character> openBracketsDeque, char currentCharacter) {
        if (openBracketsDeque.isEmpty()) {
            if (isCloseBracket(currentCharacter)) {
                return true;
            }
            openBracketsDeque.push(currentCharacter);
        } else {
            if (isOpenBracket(currentCharacter)) {
                openBracketsDeque.push(currentCharacter);
            } else {
                Character topCharacter = openBracketsDeque.pop();
                return !isCorrectBracketClosed(topCharacter, currentCharacter);
            }
        }
        return false;
    }

    private boolean isCorrectBracketClosed(Character topCharacter, char currentCharacter) {
        switch (topCharacter) {
            case OPEN_PARENTHESIS:
                return currentCharacter == CLOSE_PARENTHESIS;
            case OPEN_SQUARE_BRACKET:
                return currentCharacter == CLOSE_SQUARE_BRACKET;
            case OPEN_CURLY_BRACE:
                return currentCharacter == CLOSE_CURLY_BRACE;
            default:
                return false;
        }
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
