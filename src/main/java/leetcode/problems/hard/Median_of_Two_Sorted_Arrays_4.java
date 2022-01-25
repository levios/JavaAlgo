package leetcode.problems.hard;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The median is the middle number in a sorted, ascending or descending, list of numbers.
 * The overall run time complexity should be O(log (m+n)).
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Median_of_Two_Sorted_Arrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median1 = 0.0, median2 = 0.0;
        // we will locate mid of both nums1 and nums2
        // m1 := mid nums1
        // m2 := mid nums2
        // we will find out how many numbers go before m2
        int len = nums1.length+nums2.length;
        if (len % 2 == 0) {
            int index1 = len/2;
            int index2 = len/2-1;
            if (nums1.length == 0) {
                median1 = nums2[index1];
                median2 = nums2[index2];
            } else if (nums2.length == 0) {
                median1 = nums1[index1];
                median2 = nums1[index2];
            } else {
                int idx1 = nums1.length / 2;
                int idx2 = nums2.length / 2;
                int m1 = nums1[idx1];
                int m2 = nums2[idx2];
                //int idx = Arrays.binarySearch(nums2, m1);


                // we need to find the len/2 position
                if (nums1.length <= nums2.length) {
                    // let's use nums2, because that's the bigger
                    int pos = Math.min(nums2.length - 1, len / 2);
                    int i = nums2[pos];
                    int idx = Arrays.binarySearch(nums1, i);
                    //if (idx)
                } else {

                }
            }
        } else {
            int index = len/2; // only 1 index;
            if (nums1.length == 0) {
                median1 = median2 = nums2[nums2.length / 2];
            } else if (nums2.length == 0) {
                median1 = median2 = nums1[nums1.length / 2];
            } else {
                // we need to find the len/2 position
                // there are len/2-1 elements before this
                if (nums1.length < nums2.length) /*   it's never ==   */ {
                    // let's use nums2, because that's the bigger
                    int start = 0;
                    int end = nums2.length-1;
                    int mid = (start + end) / 2;
                    int i = nums2[mid];
                    int idx = Arrays.binarySearch(nums1, i);
                    while (idx + mid != index) {
                        if (idx + mid > index) {
                            //mid =
                        } else {

                        }
                    }
                } else {

                }
            }
        }
        return (median1 + median2) / 2;
    }

    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays_4 x = new Median_of_Two_Sorted_Arrays_4();
        System.out.println(x.findMedianSortedArrays(new int[]{1,3,5}, new int[]{2,4}));
    }
}
