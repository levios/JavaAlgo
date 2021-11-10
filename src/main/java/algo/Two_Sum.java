package algo;

import java.util.*;

/**
 * Simple 2-Sum problem
 *
 *  Time complexity: O(n)
 *  Space complexity: O(n)
 */
public class Two_Sum {

    List<List<Integer>> twoSum(int[] a, int k) {
        List<List<Integer>> res = new LinkedList<>();

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (m.containsKey(a[i])) {
                m.put(a[i], 2);
            } else {
                m.put(a[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (m.containsKey(k - entry.getKey())) {
                if (entry.getKey() < k/2.0) {
                    res.add(Arrays.asList(entry.getKey(), k - entry.getKey()));
                } else if (entry.getKey() == k/2 && entry.getValue() == 2) {
                    res.add(Arrays.asList(entry.getKey(), k - entry.getKey()));
                } else {
                    // already processed this pair
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Two_Sum app = new Two_Sum();
        System.out.println(app.twoSum(new int[] {5, 3, 7, 0, 1, 4, 2},  5));
        System.out.println(app.twoSum(new int[] {-1,0,1,2,-1,-4}, 0));
    }

}
