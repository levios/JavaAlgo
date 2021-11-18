package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n]
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class Numbers_Disappeared_in_Array_448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        Boolean[] found = new Boolean[nums.length+1];
        for (int num : nums) {
            if (num <= nums.length)
                found[num] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!Boolean.TRUE.equals(found[i]))
                disappeared.add(i);
        }
        return disappeared;
    }

    public static void main(String[] args) {
        Numbers_Disappeared_in_Array_448 app = new Numbers_Disappeared_in_Array_448();
        System.out.println(app.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(app.findDisappearedNumbers(new int[]{1,1}));
    }
}
