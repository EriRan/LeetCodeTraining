package fi.eriran.leetcode.arrays;

import java.util.Deque;

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
        int potentialRainWater = 0;

        for (int i = findFirstNonZero(height); i < height.length; i++) {
            int currentHeight = height[i];
            //Find "the next side of the pond"
            for (int j = i + 1; j < height.length; j++) {
                int pondHeigth = height[j];
                if (pondHeigth < currentHeight) {
                    potentialRainWater += currentHeight - pondHeigth;
                } else {
                    rainWaterCount += potentialRainWater;
                    i = j - 1;
                    break;
                }
            }
            potentialRainWater = 0;
        }

        //Some kind of two pointer solution?
        return rainWaterCount;
    }

    private int findFirstNonZero(int[] height) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                return i;
            }
        }
        return height.length;
    }

    private void addToCurrentLimitingHeight(int currentHeight, Deque<Integer> heightStack) {
        if (currentHeight != 0) {
            heightStack.push(currentHeight);
        }
    }

}
