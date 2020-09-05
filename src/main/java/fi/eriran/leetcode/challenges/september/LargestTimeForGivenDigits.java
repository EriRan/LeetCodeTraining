package fi.eriran.leetcode.challenges.september;

import java.util.Set;
import java.util.TreeSet;

public class LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] array) {
        //We must have at least one 0, 1 or 2 for this this to work
        //index 1 allowed: 0,1,2
        //index 2 allowed: 0,1,2,3
        //index 3 allowed: 0,1,2,3,4,5
        //index 4 allows anything
        StringBuilder clockTimeBuilder = new StringBuilder();
        Set<Integer> usedIndexes = new TreeSet<>();
        Integer hourOneIndex = findLargestPossible(array, clockTimeBuilder, 2, usedIndexes);
        if (hourOneIndex == null) {
            return "";
        }
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
