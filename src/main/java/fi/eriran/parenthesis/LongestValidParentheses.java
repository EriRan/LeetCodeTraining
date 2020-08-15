package fi.eriran.parenthesis;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 */
public class LongestValidParentheses {

    private static final char LEFT_POINTING_PARENTHESIS = '(';
    private static final char RIGHT_POINTING_PARENTHESIS = ')';

    public int longestValidParentheses(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        validateAllCharactersAreValid(string);
        return countValidParentheses(string);
    }

    private int countValidParentheses(String string) {
        int maxValidLength = 0;
        int leftValidLength = 0;
        int rightValidLength = 0;

        int leftOpenParenthesisCount = 0;
        int rightOpenParenthesisCount = 0;

        char[] charArray = string.toCharArray();
        int leftPointer = 0;
        int rightPointer = charArray.length - 1;

        while (leftPointer < rightPointer) {
            //Check left pointer
            char leftCharacter = charArray[leftPointer];
            if (LEFT_POINTING_PARENTHESIS == leftCharacter) {
                leftOpenParenthesisCount++;
            } else {
                //Encountered a closing parenthesis on the left
                if (leftOpenParenthesisCount == 0) {
                    maxValidLength = attemptToChangeMaxValidLength(leftValidLength, maxValidLength);
                    leftValidLength = 0;
                } else {
                    leftValidLength += 2;
                    leftOpenParenthesisCount--;
                }
            }
            //Check right pointer
            char rightCharacter = charArray[rightPointer];
            if (RIGHT_POINTING_PARENTHESIS == rightCharacter) {
                rightOpenParenthesisCount++;
            } else {
                //Encountered a closing parenthesis on the right
                if (rightOpenParenthesisCount == 0) {
                    //Closed in invalid situation. Attempt to change the max length
                    maxValidLength = attemptToChangeMaxValidLength(rightValidLength, maxValidLength);
                    rightValidLength = 0;
                } else {
                    rightValidLength += 2;
                    rightOpenParenthesisCount--;
                }
            }
            leftPointer++;
            rightPointer--;
        }

        //To make the pointers point to correct indexes
        if (leftPointer != rightPointer) {
            leftPointer--;
            rightPointer++;
        }

        //Close the right or left input if the pointers end up in the same location
        if (leftPointer == rightPointer) {
            char midpointCharacter = charArray[leftPointer];
            if (rightOpenParenthesisCount > 0 && midpointCharacter == LEFT_POINTING_PARENTHESIS) {
                rightValidLength += 2;
                rightOpenParenthesisCount--;
                leftOpenParenthesisCount--;
            } else if (leftOpenParenthesisCount > 0 && midpointCharacter == RIGHT_POINTING_PARENTHESIS) {
                leftValidLength += 2;
                rightOpenParenthesisCount--;
                leftOpenParenthesisCount--;
            } else {
                //The mid part causes a split. Do a max from both sides and then quit
                maxValidLength = attemptToChangeMaxValidLength(
                        leftValidLength,
                        maxValidLength);
                maxValidLength = attemptToChangeMaxValidLength(
                        rightValidLength,
                        maxValidLength);
                return maxValidLength;
            }
        }

        //Combine statuses of the pointers using the amounts of parenthesis they have open
        if (leftOpenParenthesisCount > 0 && rightOpenParenthesisCount > 0) {
            if (leftOpenParenthesisCount == rightOpenParenthesisCount) {
                leftValidLength += 2 * rightOpenParenthesisCount;
            } else if (leftOpenParenthesisCount < rightOpenParenthesisCount) {
                int closeableParenthesis = Math.abs(leftOpenParenthesisCount - rightOpenParenthesisCount);
                leftValidLength += 2 * closeableParenthesis;
                maxValidLength = attemptToChangeMaxValidLength(
                        rightValidLength,
                        maxValidLength);
                rightValidLength = 0;
            } else {
                int closeableParenthesis = Math.abs(leftOpenParenthesisCount - rightOpenParenthesisCount);
                rightValidLength += 2 * closeableParenthesis;
                maxValidLength = attemptToChangeMaxValidLength(
                        leftValidLength,
                        maxValidLength);
                leftValidLength = 0;
            }
        }

        //Deduce max valid length one more time based on the valid length values of the pointers
        if (leftValidLength > 0 && rightValidLength > 0) {
            maxValidLength = attemptToChangeMaxValidLength(
                    leftValidLength + rightValidLength,
                    maxValidLength);
        } else if (leftValidLength > 0) {
            maxValidLength = attemptToChangeMaxValidLength(
                    leftValidLength,
                    maxValidLength);
        } else if (rightValidLength > 0) {
            maxValidLength = attemptToChangeMaxValidLength(
                    rightValidLength,
                    maxValidLength);
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
            case LEFT_POINTING_PARENTHESIS:
            case RIGHT_POINTING_PARENTHESIS:
                return true;
            default:
                return false;
        }
    }
}
