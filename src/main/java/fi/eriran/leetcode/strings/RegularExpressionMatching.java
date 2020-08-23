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
 * This can be solved with better perforamance by making a custom Regex with support for just '.' and '*'
 */
public class RegularExpressionMatching {

    private static final char MATCH_ZERO_OR_MORE_PRECEDING = '*';

    public boolean isMatch(String string, String pattern) {
        validateArguments(string, pattern);
        //Shortcuts
        if (pattern.isEmpty()) {
            return string.isEmpty();
        } else {
            if (".*".equals(pattern)) {
                return true;
            }
            if (string.isEmpty()
                    && (pattern.length() == 1
                    && MATCH_ZERO_OR_MORE_PRECEDING == pattern.charAt(0))) {
                return true;
            }
        }

        return string.matches(pattern);
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
