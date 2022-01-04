package leetcode.problems.medium;

import leetcode.problems.util.TreeNode;
import java.util.*;
/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * Given the root of a binary tree, find the maximum value v for which there exist different
 * nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * A node a is an ancestor of b if either: any child of a is equal to b or any child
 * of a is an ancestor of b.
 */
public class Max_Diff_Between_Node_Ancestor_1026 {
    int MAX = 0;
    Map<TreeNode, Integer> minCache = new HashMap<>();
    Map<TreeNode, Integer> maxCache = new HashMap<>();
    public int maxAncestorDiff(TreeNode root) {
        if (root.right != null) {
            MAX = Math.max(Math.abs(root.val - min(root.right)), MAX);
            MAX = Math.max(Math.abs(root.val - max(root.right)), MAX);
            maxAncestorDiff(root.right);
        }
        if (root.left != null) {
            MAX = Math.max(Math.abs(root.val - min(root.left)), MAX);
            MAX = Math.max(Math.abs(root.val - max(root.left)), MAX);
            maxAncestorDiff(root.left);
        }
        return MAX;
    }
    int min(TreeNode root) {
        if (minCache.get(root) != null) return minCache.get(root);
        int min = root.val;
        if (root.right != null) {
            min = Math.min(min(root.right), min);
        }
        if (root.left != null) {
            min = Math.min(min(root.left), min);
        }
        minCache.put(root, min);
        return min;
    }
    int max(TreeNode root) {
        if (maxCache.get(root) != null) return maxCache.get(root);
        int max = root.val;
        if (root.right != null) {
            max = Math.max(max(root.right), max);
        }
        if (root.left != null) {
            max = Math.max(max(root.left), max);
        }
        maxCache.put(root, max);
        return max;
    }

}
