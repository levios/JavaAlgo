package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 * Tags: Sliding Window
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int longest = 1;
        int x = 0; // inclusive
        int y = 1; // exclusive
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{ put(s.charAt(0), 0); }};
        while (y < s.length()) {
            char ch = s.charAt(y);
            Integer found = map.get(ch);
            if (found != null && found >= x) {
                x = (found + 1);
            }
            map.put(ch, y);
            longest = Math.max(longest, y - x + 1);
            y++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("bbtablud")); // expected: 6
        System.out.println(l.lengthOfLongestSubstring("abcabcbb")); // expected: 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb")); // expected: 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew")); // expected: 3
        System.out.println(l.lengthOfLongestSubstring("au")); // expected: 2
        System.out.println(l.lengthOfLongestSubstring("p")); // expected: 1
    }
}
