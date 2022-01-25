package leetcode.problems.medium;

import leetcode.problems.util.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 */
public class Insert_into_Binary_Search_Tree_701 {
    // O(logn) solution to find the first empty leaf and then insert
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }
        TreeNode temp = root;
        while (true) {
            if (root.val < val) {
                if (root.right == null) {
                    root.right = newNode;
                    break;
                }
                root = root.right;
            } else /* if val < root.val */ {
                if (root.left == null) {
                    root.left = newNode;
                    break;
                }
                root = root.left;
            }
        }
        return temp;
    }

}
