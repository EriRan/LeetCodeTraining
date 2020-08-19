package fi.eriran.leetcode.strings;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * - s could be empty and contains only lowercase letters a-z.
 * - p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String string, String pattern) {
        validateArguments(string,pattern);
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
        return false;
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
