package leetcode.problems.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into
 * two subsets such that the sum of elements in both subsets is equal.
 *
 * Constraints:
    1 <= nums.length <= 200
    1 <= nums[i] <= 100
 */
class Partition_Equal_Subset_Sum_416 {
    Boolean cache[][];
    //Runtime: 90 ms, faster than 18.99%
    //Memory Usage: 62.2 MB, less than 13.92%
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1 || nums.length == 1) {
            return false;
        }
        cache = new Boolean[nums.length+1][sum+1];
        return dp(nums, 0,sum/2);
    }

    boolean dp(int[] nums, int start, int target) {
        if (target==0) return true;
        if (start > nums.length-1 || target < 0) return false;
        if (cache[start][target] != null) return cache[start][target];
        boolean incl = dp(nums, start+1, target-nums[start]);
        boolean notIncl = dp(nums, start+1, target);
        cache[start][target] = incl | notIncl;
        return incl | notIncl;
    }

    // ???
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1 || nums.length == 1) {
            return false;
        }
        int half = sum/2;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;

        int idx = nums.length-1;
        while (right < half) {
            right += nums[idx--];
        }
        if (right == half) {
            return true;
        }
        idx += 1; // we decremented 1 extra
        // 2nd stage
        // at this point, right is > half
        // swap -> starting from the smallest in right
//        while (right != half) {
//            right -=
//        }
        return false;
    }

    // TLE
    public boolean canPartition0(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1 || nums.length == 1) {
            return false;
        }
        return backtrack(nums, sum/2, new boolean[nums.length], 0, 0);
    }
    boolean backtrack(int[] nums, int target, boolean[] visited, int sum, int start) {
        if (sum == target)
            return true;
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || sum + nums[i] > target) continue;
            visited[i] = true;
            if (backtrack(nums, target, visited, sum + nums[i], i+1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Partition_Equal_Subset_Sum_416 s= new Partition_Equal_Subset_Sum_416();
        System.out.println(s.canPartition(new int[]{1,5,11,5})); //true 11
        System.out.println(s.canPartition(new int[]{1,2,3,5})); // false
        System.out.println(s.canPartition(new int[]{1,2,3,4,5,6,7})); //true 7,6,1
    }
}