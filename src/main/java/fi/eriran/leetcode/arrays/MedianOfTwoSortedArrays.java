package fi.eriran.leetcode.arrays;

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
            //Minus one so that we get the correct array index for the first midpoint
            //Second midpoint is just the first plus 1
            return findMedianFromTwoMiddlePoints(numbersOne, numbersTwo, (totalLength / 2) - 1);
        } else {
            if (totalLength == 1) {
                return getFirstOfNonEmptyArray(numbersOne, numbersTwo);
            }
            //Mid point is at totalLength/2 rounded up except if its one
            //Total length divided with two so that we get the array index that is at the half point of the length of
            // the two arrays (Eg. arrays with total size of 3 divided with 2 == 1.5 becomes 1 because integers are
            // rounded down during division)
            return findMedianFromMidpoint(numbersOne, numbersTwo, (totalLength / 2));
        }
    }

    /**
     * Find median when the total length was even. This means the median must calculated by calculating the average of
     * the two numbers in the middle.
     */
    private double findMedianFromTwoMiddlePoints(int[] numbersOne,
                                                 int[] numbersTwo,
                                                 int midpointIndex) {
        int secondMidpointIndex = midpointIndex + 1;
        int numbersOnePointer = 0;
        int numbersTwoPointer = 0;
        int[] twoMedianNumbers = new int[2];
        for (int i = 0; i <= secondMidpointIndex; i++) {
            int selectedNumber;
            if (isNumbersOneArrayUsable(numbersOne, numbersTwo, numbersOnePointer, numbersTwoPointer)) {
                selectedNumber = numbersOne[numbersOnePointer];
                numbersOnePointer++;
            } else {
                selectedNumber = numbersTwo[numbersTwoPointer];
                numbersTwoPointer++;
            }
            if (i == midpointIndex) {
                twoMedianNumbers[0] = selectedNumber;
            } else if (i == secondMidpointIndex) {
                twoMedianNumbers[1] = selectedNumber;
            }
        }
        return (twoMedianNumbers[0] + twoMedianNumbers[1]) / 2.0;
    }

    /**
     * Find the median when the total length of the two arrays is odd, meaning that the median is just the number in
     * the middle.
     */
    private double findMedianFromMidpoint(int[] numbersOne, int[] numbersTwo, int midpointIndex) {
        int numbersOnePointer = 0;
        int numbersTwoPointer = 0;
        boolean useNumbersOne = true;
        for (int i = 0; i <= midpointIndex; i++) {
            if (isNumbersOneArrayUsable(numbersOne, numbersTwo, numbersOnePointer, numbersTwoPointer)) {
                useNumbersOne = true;
                numbersOnePointer++;
            } else {
                useNumbersOne = false;
                numbersTwoPointer++;
            }
        }
        if (useNumbersOne) {
            return numbersOne[numbersOnePointer - 1];
        }
        return numbersTwo[numbersTwoPointer - 1];
    }

    /**
     * Whether number one array still has usable indexes or number two array has no usable indexes left or if the
     * number one array's current index has a smaller value than number two array's current index
     */
    private boolean isNumbersOneArrayUsable(int[] numbersOne,
                                            int[] numbersTwo,
                                            int numbersOnePointer,
                                            int numbersTwoPointer) {
        return numbersOnePointer != numbersOne.length
                && (numbersTwoPointer == numbersTwo.length
                || numbersOne[numbersOnePointer] < numbersTwo[numbersTwoPointer]);
    }

    private double getFirstOfNonEmptyArray(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2[0];
        }
        return nums1[0];
    }

    private boolean isEven(int totalLength) {
        return totalLength % 2 == 0;
    }
}
