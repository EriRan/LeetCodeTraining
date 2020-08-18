package fi.eriran.algorithm.arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] numbersOne, int[] numbersTwo) {
        int totalLength = numbersOne.length + numbersTwo.length;
        if (isEven(totalLength)) {
            //Mid point is between totalLength/2 and totalLength/2 + 1
            int midpointIndexOne = (totalLength / 2) - 1;
            int midpointIndexTwo = midpointIndexOne + 1;
            return findMedianFromTwoMiddlePoints(numbersOne, numbersTwo, midpointIndexOne, midpointIndexTwo);
        } else {
            if (totalLength == 1) {
                return getFirstOfNonEmptyArray(numbersOne, numbersTwo);
            }
            //Mid point is at totalLength/2 rounded up except if its one
            return findMedianFromMidpoint(numbersOne, numbersTwo, (int) Math.ceil(totalLength / 2.0) - 1);
        }
    }

    private boolean isEven(int totalLength) {
        return totalLength % 2 == 0;
    }

    private double findMedianFromMidpoint(int[] numbersOne, int[] numbersTwo, int midpointIndex) {
        int numbersOnePointer = 0;
        int numbersTwoPointer = 0;
        Integer selectedNumber = null;
        for (int i = 0; i <= midpointIndex; i++) {
            if (numbersOnePointer != numbersOne.length
                    && (numbersTwoPointer == numbersTwo.length
                    || numbersOne[numbersOnePointer] < numbersTwo[numbersTwoPointer])) {
                selectedNumber = numbersOne[numbersOnePointer];
                numbersOnePointer++;
            } else {
                selectedNumber = numbersTwo[numbersTwoPointer];
                numbersTwoPointer++;
            }
        }
        if (selectedNumber == null) {
            throw new IllegalStateException("Unable to find midpoint number");
        }
        return selectedNumber;
    }

    private double findMedianFromTwoMiddlePoints(int[] numbersOne,
                                                 int[] numbersTwo,
                                                 int midpointIndexOne,
                                                 int midpointIndexTwo) {
        int numbersOnePointer = 0;
        int numbersTwoPointer = 0;
        Double selectedNumberOne = null;
        Double selectedNumberTwo = null;
        for (int i = 0; i <= midpointIndexTwo; i++) {
            int selectedNumber;
            if (numbersOnePointer != numbersOne.length
                    && (numbersTwoPointer == numbersTwo.length
                    || numbersOne[numbersOnePointer] < numbersTwo[numbersTwoPointer])) {
                selectedNumber = numbersOne[numbersOnePointer];
                numbersOnePointer++;
            } else {
                selectedNumber = numbersTwo[numbersTwoPointer];
                numbersTwoPointer++;
            }
            if (i == midpointIndexOne) {
                selectedNumberOne = (double) selectedNumber;
            } else if (i == midpointIndexTwo) {
                selectedNumberTwo = (double) selectedNumber;
            }
        }
        if (selectedNumberOne == null || selectedNumberTwo == null) {
            throw new IllegalStateException("Unable to find midpoint number");
        }
        return (selectedNumberOne + selectedNumberTwo) / 2.0;
    }

    private double getFirstOfNonEmptyArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2[0];
        }
        return nums1[0];
    }
}
