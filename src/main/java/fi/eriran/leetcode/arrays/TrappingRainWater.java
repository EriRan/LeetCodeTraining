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

        //Some kind of two pointer solution?
        return rainWaterCount;
    }

}
