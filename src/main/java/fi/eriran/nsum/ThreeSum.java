package fi.eriran.nsum;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        return findUniqueTriplets(Arrays.copyOf(nums, nums.length));
    }

    private List<List<Integer>> findUniqueTriplets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        Integer previousValue = null;
        for (int i = 0; i < nums.length; i++) {
            if (previousValue != null && nums[i] == previousValue) {
                continue;
            }
            response.addAll(twoSum(nums, nums[i], i + 1));
            previousValue = nums[i];
        }
        return response;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int startPoint) {
        List<List<Integer>> twoSumTriplets = new ArrayList<>();
        Integer previousLeftNumber = null;
        for (int leftNumber = startPoint; leftNumber < nums.length - 1; leftNumber++) {
            if (previousLeftNumber != null && previousLeftNumber == nums[leftNumber]) {
                continue;
            }
            for (int rightNumber = nums.length - 1; rightNumber > startPoint && rightNumber > leftNumber; rightNumber--) {
                if (nums[leftNumber] + nums[rightNumber] + target == 0) {
                    twoSumTriplets.add(Arrays.asList(target, nums[leftNumber], nums[rightNumber]));
                    break;
                }
            }
            previousLeftNumber = nums[leftNumber];
        }
        return twoSumTriplets;
    }
}
