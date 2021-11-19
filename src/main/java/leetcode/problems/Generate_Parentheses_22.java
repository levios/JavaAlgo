package leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * >>> MEDIUM
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 1 <= n <= 8
 *
 * TAGS: recursive
 */
public class Generate_Parentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] ch = new char[2*n];
        ch[0] = '(';
        ch[2*n-1] = ')';
        populate(result, ch, n,n-1,n-1, 1);
        return result;
    }

    void populate(List<String> result, char[] ch, int n, int open, int close, int iteration) {
        if (open == 0 && close == 0) {
            result.add(new String(ch));
            return;
        }
        if (open > 0) {
            char[] ch2 = Arrays.copyOf(ch, 2*n);
            ch2[iteration] = '(';
            populate(result, ch2, n,open-1, close,iteration + 1);
        }
        if (open <= close && close > 0) {
            char[] ch2 = Arrays.copyOf(ch, 2*n);
            ch2[iteration] = ')';
            populate(result, ch2, n, open, close-1, iteration + 1);
        }
    }

    public static void main(String[] args) {
        Generate_Parentheses_22 app = new Generate_Parentheses_22();
        System.out.println(app.generateParenthesis(1));
        System.out.println(app.generateParenthesis(3));
    }
}
