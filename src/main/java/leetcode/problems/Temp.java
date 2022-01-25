package leetcode.problems;

import java.util.*;

public class Temp {

    public List<List<String>> partition(String s) {
        List<List<String>> r = new LinkedList<>();
        backtrack(r, new LinkedList<>(), new StringBuilder(), s, 0);
        return r;
    }
    void backtrack(List<List<String>> result, List<String> current, StringBuilder sb, String s, int start) {
        if (start == s.length()) {
            if (isPalindrom(sb)) {
                if (sb.length()!=0) current.add(sb.toString());
                result.add(current);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() > 0 && isPalindrom(sb)) {
                current.add(sb.toString());
                backtrack(result, new ArrayList<>(current), new StringBuilder(), s, i+1);
                current.remove(current.size()-1);
            }
        }
    }
    boolean isPalindrom(StringBuilder s) {
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Temp x = new Temp();
        System.out.println(x.partition("aab"));
        System.out.println(x.partition("a"));
        System.out.println(x.partition("efe"));
    }
}
