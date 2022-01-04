package leetcode.problems.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')'
 * find the length of the longest valid (well-formed) parentheses substring.
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 */
public class Longest_Valid_Parentheses_32 {
    /**
     * Runtime: 3 ms, faster than 31.36%
     * Memory Usage: 39.1 MB, less than 54.53%
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Character> deque = new LinkedList<>();
        List<Integer> openBrackets = new LinkedList<>();
        // track which '(' bracket was "matched" with ')' bracket
        boolean[] matched = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openBrackets.add(i);
                deque.push(c);
            } else {
                Character f = deque.peek();
                if (f == null || !f.equals('(') ) {
                    deque.clear();
                } else {
                    deque.remove();
                    int last = openBrackets.remove(openBrackets.size()-1);
                    matched[last] = true;
                    matched[i] = true;
                }
            }
        }
        // go through the array one more time, check longest array
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (matched[i]) {
                currentLength+=1;
                max = Math.max(currentLength, max);
            } else {
                currentLength = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Longest_Valid_Parentheses_32 l = new Longest_Valid_Parentheses_32();
        System.out.println(l.longestValidParentheses("(()")); // 2
        System.out.println(l.longestValidParentheses(")()())")); // 4
        System.out.println(l.longestValidParentheses("()(()")); // 2
        System.out.println(l.longestValidParentheses("()())(((((())()()((()))))")); // 18
    }
}
