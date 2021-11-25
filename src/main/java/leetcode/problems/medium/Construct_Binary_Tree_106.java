package leetcode.problems.medium;

import leetcode.problems.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Construct_Binary_Tree_106 {
    /**
     * Runtime: 42 ms, faster than 5.08% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 39.7 MB, less than 31.15% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int rootVal = postorder[postorder.length-1];
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postorderList = Arrays.stream(postorder).boxed().collect(Collectors.toList());

        int idx = inorderList.indexOf(rootVal);
        List<Integer> leftSub = inorderList.subList(0,idx);
        List<Integer> rightSub = inorderList.subList(idx+1,inorderList.size());
        List<Integer> rightLeftSub = postorderList.subList(0,leftSub.size());
        List<Integer> rightRightSub = postorderList.subList(leftSub.size(),postorderList.size()-1); // -1 because last item is root

        TreeNode root = new TreeNode(rootVal);
        buildTree(root, leftSub, rightSub, rightLeftSub, rightRightSub);
        return root;
    }

    void buildTree(TreeNode root,
                   List<Integer> inorderLeft,
                   List<Integer> inorderRight, // inorderRight size == postorderRight size
                   List<Integer> postorderLeft, // postorderLeft size == inorderLeft size
                   List<Integer> postorderRight) {

        if (!inorderLeft.isEmpty()) {
            int leftNeighbor = postorderLeft.get(postorderLeft.size()-1);

            // find new left subtree
            List<Integer> newInorderLeft = inorderLeft.subList(0, inorderLeft.indexOf(leftNeighbor));
            List<Integer> newInorderRight = inorderLeft.subList(inorderLeft.indexOf(leftNeighbor)+1, inorderLeft.size());
            // find new right subtree
            List<Integer> newPostorderLeft = postorderLeft.subList(0,newInorderLeft.size());
            List<Integer> newPostorderRight = postorderLeft.subList(newInorderLeft.size(),postorderLeft.size()-1); // -1 because last item is root

            TreeNode node = new TreeNode(leftNeighbor);
            buildTree(node, newInorderLeft, newInorderRight, newPostorderLeft, newPostorderRight);
            root.left = node;
        }

        if (!inorderRight.isEmpty()) {
            int rightNeighbor = postorderRight.get(postorderRight.size()-1);

            // find new left-right subtrees
            List<Integer> newInorderLeft = inorderRight.subList(0, inorderRight.indexOf(rightNeighbor));
            List<Integer> newInorderRight = inorderRight.subList(inorderRight.indexOf(rightNeighbor)+1, inorderRight.size());
            // find new right subtree
            List<Integer> newPostorderLeft = postorderRight.subList(0,newInorderLeft.size());
            List<Integer> newPostorderRight = postorderRight.subList(newInorderLeft.size(),postorderRight.size()-1); // -1 because last item is root

            TreeNode node = new TreeNode(rightNeighbor);
            buildTree(node, newInorderLeft, newInorderRight, newPostorderLeft, newPostorderRight);
            root.right = node;
        }

    }

    public static void main(String[] args) {
        Construct_Binary_Tree_106 app = new Construct_Binary_Tree_106();
        /**
         * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
         * Output: [3,9,20,null,null,15,7]
         */
        System.out.println(app.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
}
