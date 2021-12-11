package leetcode.problems.medium;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * tags: BINARY SEARCH
 */
public class Single_Element_in_Sorted_Array_540 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
     * Memory Usage: 39 MB, less than 74.84% of Java online submissions for Single Element in a Sorted Array.
     */
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int iStart = 0;
        int iEnd = len-1;
        while (true) {
            len = iEnd - iStart + 1;
            if (len == 1) return nums[iStart];
            int idx = (iEnd+iStart)/2;
            int sta = nums[idx-1];
            int mid = nums[idx];
            int end = nums[idx+1];
            if (mid == sta) {
                if ( (len-1) % 4 == 0) {
                    iEnd = idx;
                } else {
                    iStart = idx + 1;
                }
            } else if (mid == end) {
                if ( (len-1) % 4 == 0) {
                    iStart = idx;
                } else {
                    iEnd = idx-1;
                }
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        Single_Element_in_Sorted_Array_540 app = new Single_Element_in_Sorted_Array_540();

        System.out.println(app.singleNonDuplicate(new int[]{1,1,2,3, 3, 4,4,8,8})); // 2
        System.out.println(app.singleNonDuplicate(new int[]{3,3,7, 7, 10,11,11}));  // 10

        System.out.println(app.singleNonDuplicate(new int[]{1,1,3,3, 4, 4,5,8,8})); // 5
        System.out.println(app.singleNonDuplicate(new int[]{3,3,5, 7, 7,11,11}));   // 5

        System.out.println(app.singleNonDuplicate(new int[]{1, 1, 2}));             // 2
        System.out.println(app.singleNonDuplicate(new int[]{1,2, 2, 3,3}));         // 1
    }
}
