package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 *      a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 */
public class Balanced_Binary_Tree_110 {

    /**
     * Runtime: 2 ms, faster than 15.42%
     * Memory Usage: 42.5 MB, less than 5.30%
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    int height(TreeNode t) {
        if (t == null) return 0;
        return Math.max(height(t.left), height(t.right)) + 1;
    }

//    Map<TreeNode, Boolean> balanced = new HashMap<>();
//    Map<TreeNode, Integer> heights = new HashMap<>();
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        if (!balanced.containsKey(root)) {
//            balanced.put(root, isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1);
//        }
//        return balanced.get(root);
//    }
//    int height(TreeNode t) {
//        if (t == null) return 0;
//        if (!heights.containsKey(t)) {
//            heights.put(t, Math.max(height(t.left), height(t.right)) + 1);
//        }
//        return heights.get(t);
//    }
}
