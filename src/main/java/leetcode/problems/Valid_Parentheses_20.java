package leetcode.problems;

import java.util.*;

class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        List<Character> q = new LinkedList<>();
        List<Character> closing = Arrays.asList(']', '}', ')');
        for (char c : s.toCharArray()) {
            if (closing.contains(c)) {
                if (q.isEmpty() || isInverse(c) != q.remove(q.size()-1)) {
                    return false;
                }
            } else {
                q.add(c);
            }
        }
        return q.isEmpty();
    }

    char isInverse(char c1) {
        if (c1 == ')') return '(';
        if (c1 == ']') return '[';
        return '{';
    }

    public static void main(String[] args) {
        Valid_Parentheses_20 app  = new Valid_Parentheses_20();
        System.out.println(app.isValid("()")); // true
        System.out.println(app.isValid("()[]{}")); // true
        System.out.println(app.isValid("(]")); // false
        System.out.println(app.isValid("([)]")); // false
    }
}