package leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 * 46. Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 *
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Constraints:
 *    1 <= nums.length <= 6
 *   -10 <= nums[i] <= 10
 *   All the integers of nums are UNIQUE.
 *
 * TAGS: backtrack ; back-track ; permute ; permutation
 */
public class Permutations_46 {
    /**
     * Runtime: 1 ms, faster than 94.63%
     * Memory Usage: 39.1 MB, less than 81.03%
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perm = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(perm, new LinkedList<>(), nums, visited);
        return perm;
    }

    void backtrack(List<List<Integer>> perm, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            perm.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                int idx = current.size()-1;
                backtrack(perm, current, nums, visited);
                current.remove(idx);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations_46 p = new Permutations_46();
        System.out.println(p.permute(new int[] {1,2,3} ));
        permutorUsage();
    }

    public static void permutorUsage() {
        List<Character> characterList = "1234".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Permutor<Character> p = new Permutor<>(characterList);
        System.out.println(characterList.size() + " -> " + p.size());
        for (List<Character> s : p) {
            System.out.println(s);
        }
    }


    public static class Permutor<T> extends AbstractCollection<List<T>> {
        private final List<T> items;
        public Permutor(List<T> s) {
            items = s;
        }
        @Override
        public Iterator<List<T>> iterator() {
            if (items.size() == 1) {
                return Collections.singleton(items).iterator();
            } else {
                return new PermutingIterator<>(items);
            }
        }
        @Override
        public int size() {
            return factorial(items.size());
        }
    }

    private static class PermutingIterator<T> implements Iterator<List<T>> {
        private final T last;
        private final Iterator<List<T>> inner;
        private List<T> current;
        private int position;
        PermutingIterator(List<T> s) {
            int lastIndex = s.size() - 1;
            this.inner = new Permutor<T>(s.subList(0, lastIndex)).iterator();
            this.last = s.get(lastIndex);
        }
        @Override
        public boolean hasNext() {
            return inner.hasNext() || (current != null && position <= current.size());
        }
        @Override
        public List<T> next() {
            while(true) {
                if (current != null && position <= current.size()) {
                    List<T> n = new ArrayList<>(current);
                    n.add(position++, last);
                    return n;
                } else if (inner.hasNext()) {
                    position = 0;
                    current = inner.next();
                } else {
                    throw new IllegalStateException("no more permutations available");
                }
            }
        }
        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
