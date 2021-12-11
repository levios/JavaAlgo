package leetcode.problems.hard;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * 41. First Missing Positive
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
class First_Missing_Positive_41 {
    /**
     * Runtime: 5 ms, faster than 37.26%
     * Memory Usage: 96.7 MB, less than 57.44%
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE)
                nums[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            while (j >= 1 && j <= nums.length) {
                int temp = nums[j-1];
                nums[j-1] = Integer.MIN_VALUE;
                j = temp;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != Integer.MIN_VALUE)
                return i+1;
        return nums.length + 1;
    }

    public static void main(String[] args) {
        First_Missing_Positive_41 s = new First_Missing_Positive_41();
        System.out.println(s.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(s.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(s.firstMissingPositive(new int[]{1}));
        System.out.println(s.firstMissingPositive(new int[]{Integer.MIN_VALUE}));
        // !!! bad
        System.out.println(s.firstMissingPositive(new int[]{1, Integer.MIN_VALUE, 3}));
    }
}