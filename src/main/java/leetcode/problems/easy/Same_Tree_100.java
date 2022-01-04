package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 */
public class Same_Tree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
        return false;
    }
}
