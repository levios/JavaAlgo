package leetcode.problems.medium;

import leetcode.problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 *
 * The thief realized that all houses in this place form a binary tree.
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * Constraints:
 *      The number of nodes in the tree is in the range [1, 10^4].
 *      0 <= Node.val <= 10^4
 */
public class House_Robber_III_337 {

    Map<TreeNode, Integer> cache = new HashMap<>();

    /**
     * Top-down approach:
     * 2 decisions:
     *  either rob this one, and don't rob its children
     *  or don't rob this one
     *
     * Runtime: 3 ms, faster than 22.28%
     * Memory Usage: 38.7 MB, less than 62.35%
     */
    public int rob(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // we decide to rob this one, or not

        int robThis = node.val;
        if (node.left != null) {
            if (node.left.left != null && !cache.containsKey(node.left.left)) {
                cache.put(node.left.left, rob(node.left.left));
            }
            if (node.left.right != null && !cache.containsKey(node.left.right)) {
                cache.put(node.left.right, rob(node.left.right));
            }
            robThis += cache.getOrDefault(node.left.left, 0);
            robThis += cache.getOrDefault(node.left.right, 0);
        }
        if (node.right != null) {
            if (node.right.left != null && !cache.containsKey(node.right.left)) {
                cache.put(node.right.left, rob(node.right.left));
            }
            if (node.right.right != null && !cache.containsKey(node.right.right)) {
                cache.put(node.right.right, rob(node.right.right));
            }
            robThis += cache.getOrDefault(node.right.left, 0);
            robThis += cache.getOrDefault(node.right.right, 0);
        }

        int robChildren = 0;
        if (node.left != null && !cache.containsKey(node.left)) {
            cache.put(node.left, rob(node.left));
        }
        robChildren += cache.getOrDefault(node.left, 0);
        if (node.right != null && !cache.containsKey(node.right)) {
            cache.put(node.right, rob(node.right));
        }
        robChildren += cache.getOrDefault(node.right, 0);

        int res = Math.max(robThis, robChildren);
        cache.put(node, res);
        return res;
    }

    // Top-down approach - Slow

    public int rob0(TreeNode root) {
        return max(root, false);
    }
    /**
     * 2 decisions:
     *  either rob this one, and don't rob its children
     *  or don't rob this one
     */
    int max(TreeNode node, boolean isParentRobbed) {
        if (node == null) {
            return 0;
        }
        if (isParentRobbed) {
            // cannot rob this
            int leftMax = cache.getOrDefault(node.left, max(node.left, false));
            int rightMax = cache.getOrDefault(node.right, max(node.right, false));
            return leftMax + rightMax;
        }
        // at this point, parent is not robbed, so we decide to rob this one, or not
        int robThis = node.val + max(node.left, true) + max(node.right, true);
        int leftMax = cache.getOrDefault(node.left, max(node.left, false));
        int rightMax = cache.getOrDefault(node.right, max(node.right, false));
        int max = Math.max(robThis, leftMax + rightMax);
        cache.put(node, max);
        return max;
    }

    public static void main(String[] args) {
        House_Robber_III_337 p = new House_Robber_III_337();
        System.out.println(p.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
    }
}
