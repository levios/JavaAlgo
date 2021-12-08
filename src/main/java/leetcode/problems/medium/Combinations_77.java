package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/combinations/
 * 77. Combinations
 */
class Combinations_77 {

    /**
     * Runtime: 47 ms, faster than 16.51%
     * Memory Usage: 63.9 MB, less than 8.07%
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new LinkedList<>();
        backtrack(combs, new LinkedList<>(), n, k, 1);
        return combs;
    }

    void backtrack(List<List<Integer>> combs, List<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            combs.add(new ArrayList<>(current));
        } else {
            for (int i = start; i <= n; i++) {
                current.add(i);
                int idx = current.size()-1;
                backtrack(combs, current, n, k, i+1);
                current.remove(idx);
            }
        }
    }

    // Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).
    public List<List<Integer>> combine2(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Collections.singletonList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        Combinations_77 app = new Combinations_77();
        System.out.println(app.combine(4,2));
    }
}