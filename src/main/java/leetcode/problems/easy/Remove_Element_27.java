package leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-element/
 * 27. Remove Element
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 *
 * Return k after placing the final result in the first k slots of nums.
 */
public class Remove_Element_27 {

    /**
     * Runtime: 0 ms, faster than 100.00%.
     * Memory Usage: 37.2 MB, less than 98.36%
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k++;
            } else {
                nums[i-k] = nums[i];
            }
        }
        return nums.length - k;
    }

}
