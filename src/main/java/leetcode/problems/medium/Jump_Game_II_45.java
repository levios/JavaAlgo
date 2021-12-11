package leetcode.problems.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * 45. Jump Game II
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 *
 * Constraints:
    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
 */
class Jump_Game_II_45 {

    /**
     * Runtime: 43 ms, faster than 34.24%
     * Memory Usage: 39.7 MB, less than 64.44%
     */
    public int jump(int[] nums) {
        nums[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            int minSteps = 100_000;
            for (int j = 1; j <= Math.min(nums[i], nums.length - 1 - i); j++) {
                minSteps = Math.min(minSteps, 1 + nums[i + j]);
            }
            nums[i] = minSteps;
        }
        return nums[0];
    }

    /**
     * Runtime: 43 ms, faster than 34.24%
     * Memory Usage: 39.6 MB, less than 77.90%
     */
    public int jump0(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            int minSteps = 100_000;
            for (int j = 1; j <= Math.min(nums[i], nums.length - 1 - i); j++) {
                minSteps = Math.min(minSteps, 1 + dp[i + j]);
            }
            dp[i] = minSteps;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Jump_Game_II_45 s = new Jump_Game_II_45();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
        System.out.println(s.jump(new int[]{2,3,0,1,4}));
    }
}