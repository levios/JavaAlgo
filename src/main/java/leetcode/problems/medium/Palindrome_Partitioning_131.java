package leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 131. Palindrome Partitioning
 *
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 */
class Palindrome_Partitioning_131 {

    /**
     * Runtime: 12 ms, faster than 44.50%
     * Memory Usage: 53.1 MB, less than 58.87%
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), 0, 0, s.toCharArray());
        return result;
    }

    void backtrack(List<List<String>> result, List<String> currentList, int start, int end, char[] chars) {
        if (end >= chars.length)
            return; // doesnt work
        if (isPalindrome(chars, start, end)) {
            List<String> list = new ArrayList<>(currentList);
            list.add(new String(chars, start, end-start+1));
            if (end == chars.length-1) { // last character
                result.add(new ArrayList<>(list));
                return;
            }
            backtrack(result, list, end+1, end+1, chars);
        } else if (end == chars.length-1) {
            return;
        }
        backtrack(result, new ArrayList<>(currentList), start, end + 1, chars);
    }

    // start, end inclusive
    boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--])
                return false;
        }
        return true;
    }
    // start, end inclusive
    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    boolean isPalindrome(Deque<Character> current) {
        if (current.isEmpty()) return false;
        if (current.size() == 1) return true;
        while (current.size() > 1) {
            Character first = current.removeFirst();
            Character last = current.removeLast();
            if (first.equals(last)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome_Partitioning_131 p = new Palindrome_Partitioning_131();
        System.out.println(p.partition("a"));
        System.out.println(p.partition("adfllfop"));
        System.out.println(p.partition("abbadccd"));
    }
}