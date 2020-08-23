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
 * <p>
 * This can be solved quickly by using Java's String.matches(), but the task description wants only MATCH_ANY or
 * MATCH_ZERO_OR_MORE_PRECEDING functionality, so Java's String.matches() provides more functionality than is asked
 * for and thus costs more performance
 */
public class RegularExpressionMatching {

    private static final char MATCH_ANY = '.';
    private static final char MATCH_ZERO_OR_MORE_PRECEDING = '*';

    private int stringCharPointer;
    private int patternCharPointer;
    private Integer matchZeroOrMoreStringCheckpoint;
    private Integer matchZeroOrMorePatternCheckpoint;

    private char currentStringChar;

    public boolean isMatch(String string, String pattern) {
        validateArguments(string, pattern);
        initPrivateVariables();
        //Shortcuts
        if (pattern.isEmpty()) {
            return string.isEmpty();
        } else {
            if (".*".equals(pattern)) {
                return true;
            }
            if (string.isEmpty()) {
                return pattern.length() == 1
                        && MATCH_ZERO_OR_MORE_PRECEDING == pattern.charAt(0);
            }
        }

        return validateMatchesPattern(string, pattern);
    }

    private void initPrivateVariables() {
        stringCharPointer = 0;
        patternCharPointer = 0;
        matchZeroOrMoreStringCheckpoint = null;
    }

    /**
     * String.length() - 1 == At the last index
     * String.length() == Iteration complete
     */
    private boolean validateMatchesPattern(String string, String pattern) {
        while (patternCharPointer < pattern.length()) {
            currentStringChar = getCurrentOrLastChar(string, stringCharPointer);
            char currentPatternChar = getCurrentOrLastChar(pattern, patternCharPointer);
            if (patternCharPointer < pattern.length() - 1
                    && pattern.charAt(patternCharPointer + 1) == MATCH_ZERO_OR_MORE_PRECEDING) {
                //Next character is zero or more preceding token
                switch (currentPatternChar) {
                    case MATCH_ZERO_OR_MORE_PRECEDING:
                        patternCharPointer++;
                        break;
                    case MATCH_ANY:
                    default:
                        int stringCharPointerBefore = stringCharPointer;
                        incrementStringUntilNonMatchEncountered(
                                string,
                                currentPatternChar
                        );
                        if (stringCharPointerBefore < stringCharPointer) {
                            //Checkpoint is after the wildcard and represents a situation where the match zero or more
                            // did not match to any
                            matchZeroOrMoreStringCheckpoint = stringCharPointerBefore;
                        }
                        //Go forward 2 indexes to skip the wildcard char or to the end of the pattern if we run out of length
                        if (patternCharPointer + 2 < pattern.length()) {
                            patternCharPointer += 2;
                        } else {
                            //Pattern runs out. Make the final check for the string here
                            return stringCharPointer == string.length();
                        }
                        if (matchZeroOrMoreStringCheckpoint != null) {
                            matchZeroOrMorePatternCheckpoint = patternCharPointer;
                        }
                }
            } else {
                if (stringCharPointer == string.length()
                        && !previousWasMatchZeroOrMoreWithSameChar(pattern)) {
                    if (matchZeroOrMoreStringCheckpoint == null) {
                        return false;
                    } else {
                        stringCharPointer = matchZeroOrMoreStringCheckpoint;
                        patternCharPointer = matchZeroOrMorePatternCheckpoint;
                        matchZeroOrMoreStringCheckpoint = null;
                        matchZeroOrMorePatternCheckpoint = null;
                    }
                }
                //Next char is not a wildcard so just compare characters at pattern locations
                switch (currentPatternChar) {
                    case MATCH_ANY:
                        //Any character is fine. Continue to the next
                    case MATCH_ZERO_OR_MORE_PRECEDING:
                        //This has no affect here
                        break;
                    default:
                        if (currentStringChar != currentPatternChar) {
                            if (matchZeroOrMoreStringCheckpoint == null) {
                                return false;
                            } else {
                                stringCharPointer = matchZeroOrMoreStringCheckpoint;
                                patternCharPointer = matchZeroOrMorePatternCheckpoint;
                                matchZeroOrMoreStringCheckpoint = null;
                                matchZeroOrMorePatternCheckpoint = null;
                            }
                        }
                }
                if (stringCharPointer < string.length()) {
                    stringCharPointer++;
                }
                patternCharPointer++;
            }
        }
        //True if string iteration has reached it's end
        return stringCharPointer == string.length();
    }

    private boolean previousWasMatchZeroOrMoreWithSameChar(String pattern) {
        //To make sure current pattern pointer does not throw indexOutOfBounds at the below condition
        return patternCharPointer > 1
                //If the last iterated was a MATCH_ZERO_OR_MORE for the same letter that is the current character
                && anyPreviousMatchZeroOrMoreForCurrentChar(pattern, patternCharPointer, currentStringChar);
    }

    /**
     * Dive in to previous characters and check if they contain a wildcard for the current char
     */
    private boolean anyPreviousMatchZeroOrMoreForCurrentChar(String pattern,
                                                             int patternCharPointer,
                                                             char currentStringChar) {
        int currentDivePointer = patternCharPointer;
        while (currentDivePointer > 1) {
            if (pattern.charAt(currentDivePointer - 1) != MATCH_ZERO_OR_MORE_PRECEDING) {
                return false;
            }
            if (pattern.charAt(currentDivePointer - 2) == currentStringChar
                    || pattern.charAt(currentDivePointer - 2) == MATCH_ANY) {
                return true;
            }
            currentDivePointer -= 2;
        }
        return false;
    }

    private char getCurrentOrLastChar(String string, int charPointer) {
        if (charPointer < string.length()) {
            return string.charAt(charPointer);
        }
        return string.charAt(string.length() - 1);
    }

    private void incrementStringUntilNonMatchEncountered(String string, char matchZeroOrMore) {
        if (matchZeroOrMore == MATCH_ANY) {
            stringCharPointer = string.length();
            return;
        }
        if (stringCharPointer + 1 >= string.length()) {
            return;
        }
        char currentChar = string.charAt(stringCharPointer);
        while (currentChar == matchZeroOrMore) {
            stringCharPointer++;
            if (stringCharPointer >= string.length()) {
                //End of the string reached
                stringCharPointer = string.length();
                return;
            }
            currentChar = string.charAt(stringCharPointer);
        }
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
