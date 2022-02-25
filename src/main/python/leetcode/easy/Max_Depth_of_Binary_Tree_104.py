# 104. Maximum Depth of Binary Tree
# https://leetcode.com/problems/maximum-depth-of-binary-tree
# A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
from typing import Optional
from leetcode.TreeNode import TreeNode
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth=0
        if root is None:
            return depth
        depth += max(self.maxDepth(root.left), self.maxDepth(root.right))
        return depth + 1

if __name__ == '__main__':
    x=Solution()
    treeNode=TreeNode.create(list = [3,9,20,None,None,15,7])
    print(x.maxDepth(treeNode))
