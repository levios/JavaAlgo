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

    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        if (i >=0) {
            while (nums[i] >= nums[i-1]) {
                i--;
            }
        }



        //else {
          //  Arrays.sort(nums);
        //}
    }

    public static void main(String[] args) {

    }
}