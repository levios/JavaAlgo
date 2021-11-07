package leetcode.problems;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int longest = 1;
        int current = 1;
        int x = 0; // inclusive
        int y = 1; // exclusive
        while (y < s.length()) {
            char ch = s.charAt(y);
            String sub = s.substring(x, y);
            if (sub.indexOf(ch) == -1) { // if not found
                y++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                x++;
                current--;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb")); // expected: 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb")); // expected: 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew")); // expected: 3
        System.out.println(l.lengthOfLongestSubstring("au")); // expected: 2
        System.out.println(l.lengthOfLongestSubstring("p")); // expected: 1
    }
}
