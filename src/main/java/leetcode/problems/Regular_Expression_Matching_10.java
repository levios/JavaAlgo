package leetcode.problems;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * >>> HARD
 * Given an input string s and a pattern p, implement regular expression matching
 * with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * TAGS: recursive
 */
public class Regular_Expression_Matching_10 {

    // recursive solution
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty() ;
        }
        // at this point p.length >=1
        char p0 = p.charAt(0);
        if (s.isEmpty()) {
            if (p.length() == 1) return false;
            if (p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            }
            return false;
        }
        // at this point p.length >=1 && s.length >=1
        char s0 = s.charAt(0);
        boolean firstMatch = p0 == s0 || p0 == '.';
        if (p.length() == 1) {
            return s.length() == p.length() && firstMatch ;
        }
        // at this point p.length >=2 && s.length >=1
        char p1 = p.charAt(1);
        if (p1 == '*') {
            if (firstMatch) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (!firstMatch) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        Regular_Expression_Matching_10 app = new Regular_Expression_Matching_10();
        System.out.println(app.isMatch("aa", "a")); // false
        System.out.println(app.isMatch("aa", "a*")); // true
        System.out.println(app.isMatch("ab", ".*")); // true
        System.out.println(app.isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(app.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*")); // true
        System.out.println(app.isMatch("a", ".*..")); // false
    }
}
