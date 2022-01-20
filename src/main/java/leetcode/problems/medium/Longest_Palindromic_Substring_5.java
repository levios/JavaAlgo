package leetcode.problems.medium;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 * Given a string s, return the longest palindromic substring in s.
 */
public class Longest_Palindromic_Substring_5 {

    /**
     * try to find a small palindrom: with 2 or 3 letters, then try to expand
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        String max = "" + s.charAt(0);
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            return max;
        }
        if (isPalindrom(s)) return s;

        int longest = 1;
        for (int i = 0; i < s.length()-1; i++) {
            int current;
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (c1 == c2) {
                current = 2;
                // try to expand it both ways
                int l = i - 1;
                int r = i + 2;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        current += 2;
                        l--;
                        r++;
                    } else break;
                }
                if (current > longest) {
                    longest = current;
                    max = s.substring(l + 1, r);
                }
            }
            if (i + 2 < s.length() && c1 == s.charAt(i + 2)) {
                current = 3;
                // try to expand it both ways
                int l = i - 1;
                int r = i + 3;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        current += 2;
                        l--;
                        r++;
                    } else break;
                }
                if (current > longest) {
                    longest = current;
                    max = s.substring(l + 1, r);
                }

            }
        }
        return max;
    }

    boolean isPalindrom(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring_5 l = new Longest_Palindromic_Substring_5();
        System.out.println(l.longestPalindrome("babad"));
        System.out.println(l.longestPalindrome("cbbd"));
        System.out.println(l.longestPalindrome("abb"));
//        System.out.println(l.isPalindrom("babab"));
//        System.out.println(l.isPalindrom("baxxab"));
//        System.out.println(l.isPalindrom("babcvab"));
    }
}
