package fi.eriran.nsum;

import java.util.*;
import java.util.stream.Collectors;

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
        Set<Triplet> foundTriplets = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Triplet potentialTriplet = new Triplet(nums[i], nums[j], nums[k]);
                        if (!isPotentialAlreadyIncluded(potentialTriplet, foundTriplets)) {
                            foundTriplets.add(potentialTriplet);
                        }
                    }
                }
            }
        }
        return convertToListResponse(foundTriplets);
    }

    private List<List<Integer>> convertToListResponse(Set<Triplet> foundTriplets) {
        return foundTriplets.stream()
                .map(triplet -> Arrays.asList(triplet.one, triplet.two, triplet.three))
                .collect(Collectors.toList());
    }

    private boolean isPotentialAlreadyIncluded(Triplet potentialTriplet,
                                               Set<Triplet> response) {
        return response.contains(potentialTriplet);
    }

    static class Triplet implements Comparable<Triplet> {
        public final int one;
        public final int two;
        public final int three;

        public Triplet(int one, int two, int three) {
            List<Integer> tripletNumbers = Arrays.asList(one, two, three);
            tripletNumbers.sort(Integer::compareTo);
            this.one = tripletNumbers.get(0);
            this.two = tripletNumbers.get(1);
            this.three = tripletNumbers.get(2);
        }

        @Override
        public int compareTo(Triplet o) {
            int oneComparison = Integer.compare(this.one, o.one);
            if (oneComparison != 0){
                return oneComparison;
            }
            int twoComparison = Integer.compare(this.two, o.two);
            if (twoComparison != 0){
                return twoComparison;
            }
            return Integer.compare(this.three, this.three);
        }
    }
}
