package leetcode.problems.medium;

/**
 * https://leetcode.com/problems/jump-game/
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * Constraints:
    1 <= nums.length <= 104
    0 <= nums[i] <= 105
 */
class Jump_Game_55 {

    // Copied solution
    // Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" to the last index.
    // Check whether the current index can jump to this smallest index.
    public boolean canJump(int A[], int n) {
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+A[i]>=last)last=i;
        }
        return last<=0;
    }

    /**
     * My solution
     * Runtime: 116 ms, faster than 24.42%
     * Memory Usage: 39.8 MB, less than 76.82%
     */
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[nums.length-1] = true;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] <= 0) continue; // always false
            for (int j = 1; j <= Math.min(nums.length-1-i, nums[i]); j++) {
                if (can[i + j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }

    // TLE
    public boolean canJump0(int[] nums) {
        return canJump0(nums, 0);
    }
    private boolean canJump0(int[] nums, int start) {
        if (start >= nums.length) return false;
        if (start == nums.length-1) return true;
        for (int i = 1; i <= Math.min(nums.length-start-1, nums[start]); i++) {
            if (canJump0(nums, start + i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Jump_Game_55 a = new Jump_Game_55();
        System.out.println(a.canJump(new int[]{2,3,1,1,4}));
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
    }
}