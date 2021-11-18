package leetcode.problems;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 */
public class Longest_Common_Prefix_14 {

    // Solution number 1
    public String longestCommonPrefix0(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    // Solution number 2
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }

    String commonPrefix(String s1, String s2) {
        if (s1.equals(s2) || s2.startsWith(s1)) return s1;
        if (s1.startsWith(s2)) return s2;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            char c = s1.charAt(i);
            if (c == s2.charAt(i)) {
                prefix.append(c);
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Longest_Common_Prefix_14 app = new Longest_Common_Prefix_14();
        System.out.println(app.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(app.longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

}
