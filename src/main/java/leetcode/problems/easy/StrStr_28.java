package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/implement-strstr/
 * 28. Implement strStr()
 */
public class StrStr_28 {
    /**
     * Runtime: 2363 ms, faster than 5.00%
     * Memory Usage: 141 MB, less than 5.47%
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        for (int i = 0; i <= haystack.length()-needle.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (match(haystack, i, needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
    boolean match(String haystack, int i, String needle) {
        for (char c: needle.toCharArray()) {
            if (c != haystack.charAt(i++)) {
                return false;
            }
        }
        return true;
    }
}
