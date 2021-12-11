package leetcode.problems.medium;

import leetcode.problems.util.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Constraints:
 *   The number of nodes in the tree is in the range [0, 104].
 *   -105 <= Node.val <= 105
 *   Each node has a unique value.
 *   root is a valid binary search tree.
 *   -105 <= key <= 105
 *
 *  TAGS: BST, Binary Tree, Binary Search Tree, delete node
 */
public class Delete_Node_in_BST_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null){
                return root.left;
            }
            // at this point, it has both left AND right subtree
            // find the minimum value in the right subtree,
            // set that value to the currently found node,
            // then recursively delete the minimum value in the right subtree
            TreeNode min = findMin(root.right);
            root.val = min.val;
            // root.left = root.left;
            root.right = deleteNode(root.right, min.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Delete_Node_in_BST_450 app = new Delete_Node_in_BST_450();
        TreeNode t = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))
        );
        System.out.println(app.deleteNode(t, 3));
    }
}
