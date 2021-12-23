package algo;

import leetcode.problems.util.TreeNode;

import java.util.*;

public class Expression_tree {

//    public static TreeNode expressionTree(String postfix) {
//        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//        TreeNode t1,t2,temp;
//        for (int i = 0; i < postfix.length(); i++) {
//            if (!isOperator(postfix.charAt(i))) {
//                t1 = new TreeNode()
//                stack.push(t1);
//            }
//        }
//    }

    private static boolean isOperator(char c) {
        if (c == '*' || c == '-' || c == '+') {
            return true;
        }
        return false;
    }
}
