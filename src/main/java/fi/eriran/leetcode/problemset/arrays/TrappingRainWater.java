package fi.eriran.leetcode.problemset.arrays;

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
        WaterStateHolder stateHolder = new WaterStateHolder(height);

        while (stateHolder.leftPointer < stateHolder.rightPointer) {
            switch (Integer.compare(stateHolder.leftMaxHeight, stateHolder.rightMaxHeight)) {
                case 1:
                    moveRight(height, stateHolder);
                    break;
                case 0:
                    moveRight(height, stateHolder);
                    moveLeft(height, stateHolder);
                    break;
                case -1:
                    moveLeft(height, stateHolder);
                    break;
                default:
                    throw new IllegalStateException("Switch encountered unknown value");

            }
        }
        //Handle the last iteration when left and right pointers are equal
        if (stateHolder.leftPointer == stateHolder.rightPointer) {
            moveLeft(height, stateHolder);
        }

        return stateHolder.waterAmount;
    }

    private void moveLeft(int[] height, WaterStateHolder stateHolder) {
        int smallerMax;
        int leftHeight;
        leftHeight = height[stateHolder.leftPointer];

        stateHolder.leftMaxHeight = tryToChangeMax(stateHolder.leftMaxHeight, leftHeight);

        smallerMax = Math.min(stateHolder.leftMaxHeight, stateHolder.rightMaxHeight);

        stateHolder.waterAmount += getWaterAmount(leftHeight, smallerMax);

        stateHolder.leftPointer++;
    }

    private void moveRight(int[] height, WaterStateHolder stateHolder) {
        int smallerMax;
        int rightHeight;
        rightHeight = height[stateHolder.rightPointer];

        stateHolder.rightMaxHeight = tryToChangeMax(stateHolder.rightMaxHeight, rightHeight);

        smallerMax = Math.min(stateHolder.leftMaxHeight, stateHolder.rightMaxHeight);

        stateHolder.waterAmount += getWaterAmount(rightHeight, smallerMax);

        stateHolder.rightPointer--;
    }

    private int getWaterAmount(int height, int maximumPossible) {
        return Math.max(maximumPossible - height, 0);
    }

    private int tryToChangeMax(int currentMaxHeight, int leftHeight) {
        if (currentMaxHeight < leftHeight) {
            currentMaxHeight = leftHeight;
        }
        return currentMaxHeight;
    }

    static class WaterStateHolder {
        int waterAmount;
        int leftPointer;
        int rightPointer;
        int leftMaxHeight;
        int rightMaxHeight;

        public WaterStateHolder(int[] height) {
            waterAmount = 0;
            leftPointer = findFirstNonZeroFromLeft(height);
            rightPointer = findFirstNonZeroFromRight(height);
            leftMaxHeight = 0;
            rightMaxHeight = 0;

        }

        private int findFirstNonZeroFromLeft(int[] height) {
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    return i;
                }
            }
            return height.length;
        }

        private int findFirstNonZeroFromRight(int[] height) {
            for (int i = height.length - 1; i > 0; i--) {
                if (height[i] != 0) {
                    return i;
                }
            }
            return height.length;
        }
    }

}
