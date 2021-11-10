package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
public class Leetcode_3Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (List<Integer> list : twoSum(nums, -nums[i], i)) {
                list.add(nums[i]);
                Collections.sort(list);
                res.add(list);
            }
        }
        return new ArrayList<>(res);
    }

    List<List<Integer>> twoSum(int[] a, int k, int skipIndex) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (i != skipIndex) {
                if (m.containsKey(a[i])) {
                    m.put(a[i], 2);
                } else {
                    m.put(a[i], 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (m.containsKey(k - entry.getKey())) {
                if (
                   entry.getKey() < k/2.0 ||
                   (entry.getKey() == k/2 && entry.getValue() == 2)
                ) {
                    List<Integer> l = new ArrayList<>();
                    l.add(entry.getKey());
                    l.add(k - entry.getKey());
                    res.add(l);
                }
                // else: already processed this pair
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_3Sum_15 app = new Leetcode_3Sum_15();
        System.out.println(app.threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
    }

}
