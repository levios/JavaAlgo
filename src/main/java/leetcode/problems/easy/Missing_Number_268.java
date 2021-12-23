package leetcode.problems.easy;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the nums.
 * Constraints:
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique
 */
public class Missing_Number_268 {
    /**
     * Runtime: 1 ms, faster than 55.62%
     * Memory Usage: 38.7 MB, less than 99.56%
     */
    public int missingNumber(int[] nums) {
        int sum = (nums.length+1) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    /**
     * Any number XOR itself will become 0, any number XOR with 0 will stay unchanged.
     * So if every number from 1...n XOR with itself except the missing number, the result will be the missing number.
     */
    public int missing_number_XOR(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    /**
     * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     * Given A = [1, 2, 3], the function should return 4.
     * Given A = [−1, −3], the function should return 1.
     * Assume that:
     * N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000]. Complexity:
     */
    int missing(int[] array) {
        if (array == null) return -1;
        int[] a = new int[array.length];

        for (int j : array) {
            if (j <= array.length && j > 0) {
                a[j-1] = 1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

}
