package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/consecutive-characters/
 * 1446. Consecutive Characters
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * Given a string s, return the power of s.
 * Constraints:
    1 <= s.length <= 500
    s consists of only lowercase English letters.
 */
class Consecutive_Characters_1446 {
    public int maxPower(String s) {
        int max = 1;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                current++;
                max = Math.max(current, max);
            } else {
                current = 1;
            }
        }
        return max;
    }
}