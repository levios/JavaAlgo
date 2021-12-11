package leetcode.problems.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * 31. Next Permutation
 *
 * Rearrange numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
class Next_Permutation_31 {

    /**
     * Runtime: 1 ms, faster than 45.22%
     * Memory Usage: 40.5 MB, less than 14.61%
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length-1;
        // find first index from the end where the previous number is smaller (from this index, it's decreasing order)
        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if (i == 0) { // haven't found
            Arrays.sort(nums);
            return;
        }
        // find smallest number after index i (inclusive) that is bigger than nums[i-1]
        int j = i;
        while (j < nums.length && nums[j] > nums[i-1]) {
            ++j;
        }
        // swap them (use j-1, because we went 1 further)
        int temp = nums[j-1];
        nums[j-1] = nums[i-1];
        nums[i-1] = temp;
        // sort numbers after i
        if (i < nums.length-1) {
            Arrays.sort(nums, i, nums.length);
        }
    }

    public static void main(String[] args) {

    }
}