package fi.eriran.leetcode.challenges.september;

import java.util.Set;
import java.util.TreeSet;

public class LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] array) {
        //We must have at least one 0, 1 or 2 for this this to work
        StringBuilder clockTimeBuilder = new StringBuilder();
        Set<Integer> usedIndexes = new TreeSet<>();

        Integer hourOneIndex = findLargestFirstHour(array, clockTimeBuilder, usedIndexes);
        if (hourOneIndex == null) return "";
        usedIndexes.add(hourOneIndex);
        Integer hourTwoIndex = findLargestSecondHour(array, clockTimeBuilder, usedIndexes, array[hourOneIndex]);
        if (hourTwoIndex == null) {
            return "";
        }
        usedIndexes.add(hourTwoIndex);
        clockTimeBuilder.append(":");
        Integer minuteOneIndex = findLargestPossible(array, clockTimeBuilder, 5, usedIndexes);
        if (minuteOneIndex == null) {
            return "";
        }
        usedIndexes.add(minuteOneIndex);
        Integer minuteTwoIndex = findLargestPossible(array, clockTimeBuilder, 9, usedIndexes);
        if (minuteTwoIndex == null) {
            return "";
        }
        usedIndexes.add(minuteTwoIndex);
        return clockTimeBuilder.toString();
    }

    private Integer findLargestFirstHour(int[] array, StringBuilder clockTimeBuilder, Set<Integer> usedIndexes) {

        if (is2Usable(array)) {
            return findLargestPossible(array, clockTimeBuilder, 2, usedIndexes);
        }
        return findLargestPossible(array, clockTimeBuilder, 1, usedIndexes);
    }

    private Integer findLargestSecondHour(int[] array,
                                          StringBuilder clockTimeBuilder,
                                          Set<Integer> usedIndexes,
                                          int hourOneValue) {
        if (hourOneValue == 2) {
            return findLargestPossible(array, clockTimeBuilder, 3, usedIndexes);
        } else {
            return findLargestPossible(array, clockTimeBuilder, 9, usedIndexes);
        }
    }

    private boolean is2Usable(int[] array) {
        //Does it have 2
        //and does it have one more number that is less than 4 for the second hour
        // and one more less than 6 for the first minute
        boolean hasTwo = false;
        boolean hasLessThanFour = false;
        boolean hasLessThanSix = false;
        for (int number : array) {
            if (!hasTwo && number == 2) {
                hasTwo = true;
            } else if (!hasLessThanFour && number < 4) {
                hasLessThanFour = true;
            } else if (number < 6) {
                hasLessThanSix = true;
            }
        }
        return hasTwo && hasLessThanFour && hasLessThanSix;
    }

    private Integer findLargestPossible(int[] array,
                                        StringBuilder clockTimeBuilder,
                                        int largestAllowed,
                                        Set<Integer> usedIndexes) {
        Integer maxPossible = null;
        Integer maxPossibleIndex = null;
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (usedIndexes.contains(i) || currentNumber > largestAllowed) {
                continue;
            }
            if (currentNumber == largestAllowed) {
                clockTimeBuilder.append(currentNumber);
                return i;
            }
            if (maxPossible == null || currentNumber > maxPossible) {
                maxPossible = currentNumber;
                maxPossibleIndex = i;
            }
        }
        if (maxPossible != null) {
            clockTimeBuilder.append(maxPossible);
        }
        return maxPossibleIndex;
    }
}
