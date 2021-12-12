package leetcode.problems.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
public class Maximum_Subarray_Problem_53 {

    /**
     * Kadane's algorithm
     * https://en.wikipedia.org/wiki/Maximum_subarray_problem
     * Runtime: 1 ms, faster than 100.00%
     * Memory Usage: 90.5 MB, less than 5.20%
     */
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

    public static void main(String[] args) {
        Maximum_Subarray_Problem_53 app = new Maximum_Subarray_Problem_53();
        System.out.println(app.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // 6
    }

}
