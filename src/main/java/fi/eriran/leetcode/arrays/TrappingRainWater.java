package fi.eriran.leetcode.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.
 * <p>
 * *Image here*
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        //Shortcut
        if (height == null || height.length < 3) {
            return 0;
        }

        return findTrapCount(height);
    }

    private int findTrapCount(int[] height) {
        int rainWaterCount = 0;

        int leftPointer = findFirstNonZeroFromLeft(height);
        int rightPointer = findFirstNonZeroFromRight(height);
        int leftFoundMax = 0;
        int rightFoundMax = 0;

        while (leftPointer <= rightPointer) {
            if (leftPointer == rightPointer) {
                int leftHeight = height[leftPointer];
                leftFoundMax = tryToChangeMax(leftFoundMax, leftHeight);
                int smallerMax = Math.min(leftFoundMax, rightFoundMax);
                rainWaterCount += getWaterAmount(leftHeight, smallerMax);
                break;
            }
            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];

            leftFoundMax = tryToChangeMax(leftFoundMax, leftHeight);
            rightFoundMax = tryToChangeMax(rightFoundMax, rightHeight);

            int smallerMax = Math.min(leftFoundMax, rightFoundMax);

            rainWaterCount += getWaterAmount(leftHeight, smallerMax);
            rainWaterCount += getWaterAmount(rightHeight, smallerMax);

            if (leftFoundMax > rightFoundMax) {
                rightPointer--;
            } else if (rightFoundMax > leftFoundMax) {
                leftPointer++;
            } else {
                leftPointer++;
                rightPointer--;
            }
        }

        //Some kind of two pointer solution?
        return rainWaterCount;
    }

    private int getWaterAmount(int height, int maximumPossible) {
        return Math.max(maximumPossible - height, 0);
    }

    private int tryToChangeMax(int leftFoundMax, int leftHeight) {
        if (leftFoundMax < leftHeight) {
            leftFoundMax = leftHeight;
        }
        return leftFoundMax;
    }

    private int findFirstNonZeroFromRight(int[] height) {
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] != 0) {
                return i;
            }
        }
        return height.length;
    }

    private int findFirstNonZeroFromLeft(int[] height) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                return i;
            }
        }
        return height.length;
    }

}
