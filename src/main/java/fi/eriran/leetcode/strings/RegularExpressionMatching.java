package fi.eriran.leetcode.strings;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * - s could be empty and contains only lowercase letters a-z.
 * - p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class RegularExpressionMatching {

    private static final char MATCH_ANY = '.';
    private static final char MATCH_ZERO_OR_MORE_PRECEDING = '*';

    public boolean isMatch(String string, String pattern) {
        validateArguments(string, pattern);
        //Shortcuts
        if (string.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        if (".*".equals(pattern)) {
            return true;
        }
        return validateMatchesPattern(string, pattern);
    }

    private boolean validateMatchesPattern(String string, String pattern) {
        int stringCharPointer = 0;
        int patternCharPointer = 0;
        while (patternCharPointer < pattern.length() - 1) {
            char currentStringChar = getCurrentOrLastChar(string, stringCharPointer);
            char currentPatternChar = getCurrentOrLastChar(pattern, patternCharPointer);
            if (patternCharPointer < pattern.length() - 1
                    && pattern.charAt(patternCharPointer + 1) == MATCH_ZERO_OR_MORE_PRECEDING) {
                //Next character is zero or more preceding token
                switch (currentPatternChar) {
                    case MATCH_ANY:
                        //This can end with the whole string being valid
                        return patternCharPointer == pattern.length() - 1
                                || allRemainingAreWildcards(patternCharPointer, pattern);
                    case MATCH_ZERO_OR_MORE_PRECEDING:
                        patternCharPointer++;
                        break;
                    default:
                        stringCharPointer = incrementStringUntilNonMatchEncountered(
                                stringCharPointer,
                                string,
                                currentPatternChar
                        );
                        //Go forward 2 indexes to skip the wildcard char or to the end of the pattern if we run out of length
                        if (patternCharPointer + 2 < pattern.length()) {
                            patternCharPointer += 2;
                        }
                        else {
                            //Pattern runs out. Make the final check for the string here
                            return stringCharPointer == string.length() - 1;
                        }
                }
            } else {
                //Next char is not a wildcard so just compare characters at pattern locations
                switch (currentPatternChar) {
                    case MATCH_ANY:
                        //Any character is fine. Continue to the next
                    case MATCH_ZERO_OR_MORE_PRECEDING:
                        //This has no affect here
                        break;
                    default:
                        if (currentStringChar != currentPatternChar) {
                            return false;
                        }
                }
                if (stringCharPointer + 1 < string.length()) {
                    stringCharPointer++;
                }
                if (patternCharPointer + 1 < pattern.length()) {
                    patternCharPointer++;
                }
            }
        }
        //True if both pattern and string iteration reached end
        return stringCharPointer == string.length() - 1 && patternCharPointer == pattern.length() - 1;
    }

    private char getCurrentOrLastChar(String string, int charPointer) {
        if (charPointer < string.length()) {
            return string.charAt(charPointer);
        }
        return string.charAt(string.length() - 1);
    }

    private int incrementStringUntilNonMatchEncountered(int stringCharPointer, String string, char matchZeroOrMore) {
        if (stringCharPointer + 1 >= string.length()) {
            return stringCharPointer;
        }
        char currentChar = string.charAt(stringCharPointer);
        while (currentChar == matchZeroOrMore) {
            stringCharPointer++;
            if (stringCharPointer >= string.length()) {
                //End of the string reached
                return string.length() - 1;
            }
            currentChar = string.charAt(stringCharPointer);
        }
        return stringCharPointer;
    }

    private boolean allRemainingAreWildcards(int patternCharPointer, String pattern) {
        char currentPatternChar = pattern.charAt(patternCharPointer);
        while (currentPatternChar == MATCH_ZERO_OR_MORE_PRECEDING && patternCharPointer < pattern.length() - 1) {
            patternCharPointer++;
            currentPatternChar = pattern.charAt(patternCharPointer);
        }
        return pattern.charAt(patternCharPointer) == MATCH_ZERO_OR_MORE_PRECEDING
                && patternCharPointer == pattern.length() - 1;
    }

    private void validateArguments(String string, String pattern) {
        if (string == null) {
            throw new IllegalArgumentException("String was null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern was null");
        }
    }
}
