package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */
public class Path_Sum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.right == null && root.left == null) {
            return targetSum == root.val;
        }
        int diff = targetSum - root.val;
        boolean isLeft = false, isRight = false;
        if (root.left != null) {
            isLeft = hasPathSum(root.left, diff);
        }
        if (root.right != null) {
            isRight = hasPathSum(root.right, diff);
        }
        return isLeft || isRight;
    }
}
