package leetcode.problems.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 26. Remove Duplicates from Sorted Array
 *
 * Return k after placing the final result in the first k slots of nums.
 */
public class Remove_Duplicates_Sorted_Array_26 {

    /**
     * Runtime: 1 ms, faster than 82.33%
     * Memory Usage: 44.5 MB, less than 23.95%
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int prev = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (prev != current) {
                nums[k++] = current;
            }
            prev = current;
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return k;
    }

    public static void main(String[] args) {
        Remove_Duplicates_Sorted_Array_26 app = new Remove_Duplicates_Sorted_Array_26();
        System.out.println(app.removeDuplicates(new int[]{1,1,2}));
    }


}
