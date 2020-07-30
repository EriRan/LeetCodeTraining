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
        return findUniqueTriplets(nums, createAuxiliary(nums));
    }

    /**
     * Use this array to store data about two pairs of numbers in the parameter array
     */
    private List<Pair> createAuxiliary(int[] nums) {
        List<Pair> auxiliary = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                auxiliary.add(new Pair(nums[i], nums[j], i, j));
            }
        }
        return auxiliary;
    }

    private List<List<Integer>> findUniqueTriplets(int[] nums, List<Pair> auxiliary) {
        List<List<Integer>> response = new ArrayList<>();
        for (Pair pair : auxiliary) {
            for (int i = 0; i < nums.length; i++) {
                if (i == pair.indexOne || i == pair.indexTwo) {
                    continue;
                }
                if (pair.sum + nums[i] == 0) {
                    List<Integer> potentialTriplet = Arrays.asList(pair.one, pair.two, nums[i]);
                    potentialTriplet.sort(Integer::compareTo);
                    if (!isPotentialAlreadyIncluded(potentialTriplet, response)) {
                        response.add(potentialTriplet);
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

    static class Pair {
        public int one;
        public int two;
        public int indexOne;
        public int indexTwo;
        public int sum;

        public Pair(int one, int two, int indexOne, int indexTwo) {
            this.one = one;
            this.two = two;
            this.indexOne = indexOne;
            this.indexTwo = indexTwo;
            this.sum = one + two;
        }
    }
}
