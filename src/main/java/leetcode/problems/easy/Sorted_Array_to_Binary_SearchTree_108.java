package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;
import java.util.*;
/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never
 * differs by more than one.
 * Constraints: 1 <= nums.length <= 10^4
 */
public class Sorted_Array_to_Binary_SearchTree_108 {
    ///////////////
    // recursive //
    ///////////////
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
    ///////////////
    // iterative //
    ///////////////
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35218/Java-Iterative-Solution
    public TreeNode sortedArrayToBST_iterative(int[] nums) {
        if (nums.length == 0) return null;
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> right = new LinkedList<>();
        Deque<TreeNode> d = new LinkedList<>();
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        left.add(0);
        left.add(mid-1);
        right.add(mid+1);
        right.add(nums.length);
        d.add(root);
        while (!d.isEmpty()) {
            TreeNode n = d.poll();
            int lEnd = left.poll();
            int lSrt = left.poll();
            int rEnd = right.poll();
            int rSrt = right.poll();
            if (n!=null) {
                d.add(n.left);
                d.add(n.right);
                int rMid = (rSrt+rEnd)/2;
                if (rEnd >= rSrt) {
                    // TODO
                }
            }
        }
        return root;
    }

}
