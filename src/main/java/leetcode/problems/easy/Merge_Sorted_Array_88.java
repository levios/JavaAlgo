package leetcode.problems.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 88. Merge Sorted Array
 */
class Merge_Sorted_Array_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1_new = Arrays.copyOf(nums1, m);
        int idx = 0, mm = 0, nn = 0;
        while (nn < n && mm < m) {
            if (num1_new[mm] < nums2[nn]){
                nums1[idx++] = num1_new[mm++];
            } else {
                nums1[idx++] = nums2[nn++];
            }
        }
        while (mm < m) {
            nums1[idx++] = num1_new[mm++];
        }
        while (nn < n) {
            nums1[idx++] = nums2[nn++];
        }
    }

    public static void main(String[] args) {
        Merge_Sorted_Array_88 m = new Merge_Sorted_Array_88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        m.merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
    }
}