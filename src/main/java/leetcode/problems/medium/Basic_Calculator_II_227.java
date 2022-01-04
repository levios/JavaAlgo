package leetcode.problems.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii
 * Basic Calculator II
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * All intermediate results will be in the range of [-231, 231 - 1].
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 */
public class Basic_Calculator_II_227 {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) &&
                    !Character.isWhitespace(currentChar) ||
                    i == s.length() - 1) {
                if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        return result + lastNumber + currentNumber;
    }

    public int calculate_stack(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) &&
                    !Character.isWhitespace(currentChar) ||
                    i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Basic_Calculator_II_227 b = new Basic_Calculator_II_227();
        System.out.println(b.calculate("3+2*2")); // 7
        System.out.println(b.calculate(" 3/2 ")); // 1
        System.out.println(b.calculate(" 3+5 / 2 ")); // 5
        System.out.println(b.calculate("2-3+4")); // 3
        System.out.println(b.calculate("3+2*2-4")); // 3
    }
}
