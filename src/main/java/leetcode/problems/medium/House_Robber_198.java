package leetcode.problems.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
public class House_Robber_198 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i-1] + val, memo[i]);
        }
        return memo[nums.length];
    }

    /**
     * This is faster
     * the order is: prev2, prev1, num
    */
    public int rob0(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        House_Robber_198 app = new House_Robber_198();
        System.out.println(app.rob(new int[]{1,2,3,1}));
        System.out.println(app.rob(new int[]{183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211}));
        System.out.println(app.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
