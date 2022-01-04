package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null || t1.val != t2.val)
            return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
    // TODO: Iteratvie approach:
    // https://leetcode.com/problems/symmetric-tree/discuss/33089/My-C%2B%2B-Accepted-code-in-16ms-with-iteration-solution
}
