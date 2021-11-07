package leetcode;

import java.util.*;

/**
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * Kadane's algorithm
 */
public class Maximum_Subarray_Problem {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (curr > maxSum)
                maxSum = curr;
            if (curr < 0) curr = 0;
        }
        return maxSum;
    }

}
