package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 * 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * Tags: Binary Search
 */
public class Search_Insert_Position_35 {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 40.4 MB, less than 23.58%
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int idx = 0;
        while (start < end) {
            idx = (end + start) / 2;
            if (nums[idx] == target) {
                return idx;
            }
            if (nums[idx] < target) {
                if (start == idx) {
                    return idx+1;
                }
                start = idx;
            } else {
                if (end == idx) {
                    return end-1;
                }
                end = idx;
            }
        }
        return idx;
    }

    // same, but simpler
    int searchInsert0(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int idx = (end + start) / 2;
            if (nums[idx] == target) {
                return idx;
            }
            if (nums[idx] <= target) {
                start = idx+1;
            } else {
                end = idx-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Search_Insert_Position_35 app = new Search_Insert_Position_35();
        System.out.println(app.searchInsert(new int[]{1,3,5,6}, 5));//2
        System.out.println(app.searchInsert(new int[]{1,3,5,6}, 2));//1
        System.out.println(app.searchInsert(new int[]{1,3,5,6}, 7));//4
        System.out.println(app.searchInsert(new int[]{1}, 0));//4
    }
}
