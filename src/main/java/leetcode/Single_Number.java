package leetcode;

import java.util.*;

public class Single_Number {
    // Given a non-empty array of integers, every element appears twice except for one.
    // Find that single one.

    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }
        return sum;
    }

    /////// SLOW solution //////////////
//    public int singleNumber(int[] nums) {
//        Set<Integer> all = new HashSet<>(nums.length / 2);
//        for (int i : nums) {
//            if (all.contains(i)) {
//                all.remove(i);
//            } else {
//                all.add(i);
//            }
//        }
//        return (Integer)(all.toArray()[0]);
//    }
}
