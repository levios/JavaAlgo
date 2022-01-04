package leetcode.problems.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 312. Burst Balloons
 * https://leetcode.com/problems/burst-balloons/
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
 * represented by an array nums. You are asked to burst all the balloons.
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
 * If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with
 * a 1 painted on it.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * Constraints:
    n == nums.length
    1 <= n <= 500
    0 <= nums[i] <= 100
 */
public class Burst_Balloons_312 {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxCoins(nums, 0, nums.length-1, dp);
    }
    /**
     * Imagine we burst index i at the end
     */
    int maxCoins(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        int max = 0;
        for (int i = start; i <= end; i++) {
            int current = maxCoins(nums, start, i-1, dp)
                    + maxCoins(nums, i+1, end, dp)
                    + get(nums,i) * get(nums,start-1) * get(nums,end+1);
            max = Math.max(current, max);
        }
        dp[start][end] = max;
        return max;
    }
    int get(int[] nums, int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        }
        return nums[i];
    }
    public static void main(String[] args) {
        Burst_Balloons_312 x = new Burst_Balloons_312();
        System.out.println(x.maxCoins(new int[]{3,1,5,8}));
        System.out.println(x.maxCoins(new int[]{1,5}));
        System.out.println(x.maxCoins(new int[]{9,76,64,21,97}));
    }
}
