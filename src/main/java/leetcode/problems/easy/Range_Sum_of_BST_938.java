package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 938. Range Sum of BST
 *
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
class Range_Sum_of_BST_938 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
     if (root == null) return 0;
     if (root.val >= low && root.val <= high) {
         sum += root.val;
     }
     if (root.val > low) {
         rangeSumBST(root.left, low, high);
     }
     if (root.val < high) {
         rangeSumBST(root.right, low, high);
     }
     return sum;
    }

}