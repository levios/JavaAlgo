package leetcode.problems.easy;

import leetcode.problems.util.Pair;

import java.util.*;

public class Minimum_Absolute_Difference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> pairs = new LinkedList<>();
        for (int i = 0; i < arr.length-1; i++) {
            int d = arr[i+1]-arr[i];
            if (d < minDiff) {
                minDiff = d;
                pairs.clear();
                List<Integer> p = new ArrayList<>();
                p.add(arr[i]);
                p.add(arr[i+1]);
                pairs.add(p);
            } else if (d == minDiff) {
                List<Integer> p = new ArrayList<>();
                p.add(arr[i]);
                p.add(arr[i+1]);
                pairs.add(p);
            }
        }
        return pairs;
    }
}
