package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class Climbing_Stairs_70 {

    // long solution - store all n results
    public int climbStairs_long(int n) {
        if (n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }

    // short solution - only need to store previous 2
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int prevprev = 1;
        int prev = 2;
        for (int i = 3; i < n; i++) {
            int temp = prevprev;
            prevprev = prev;
            prev = temp + prev;
        }
        return prevprev + prev;
    }
}
