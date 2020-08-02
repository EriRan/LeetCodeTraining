package fi.eriran.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return findUniqueTriplets(nums);
    }

    /**
     * Use this array to store data about two pairs of numbers in the parameter array
     */
    private List<List<Integer>> findUniqueTriplets(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> potentialTriplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        potentialTriplet.sort(Integer::compareTo);
                        if (!isPotentialAlreadyIncluded(potentialTriplet, response)) {
                            response.add(potentialTriplet);
                        }
                    }
                }
            }
        }
        return response;
    }

    private boolean isPotentialAlreadyIncluded(List<Integer> potentialTriplet,
                                               List<List<Integer>> response) {
        return response.stream().anyMatch(triplet -> triplet.equals(potentialTriplet));
    }
}
