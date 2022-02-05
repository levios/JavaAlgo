from leetcode import TreeNode
from typing import List

# 1305. All Elements in Two Binary Search Trees
# https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
# Given two binary search trees root1 and root2, return a list containing all the
# integers from both trees sorted in ascending order.

class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        list1 = []
        self.inorder(root1, list1)
        list2 = []
        self.inorder(root2, list2)
        return self.mergeSort(list1, list2)


    def mergeSort(self, list1: List[int], list2: List[int])-> List[int]:
        list = []
        i, j = 0, 0
        while i < len(list1) or j < len(list2):
            if i >= len(list1):
                list.append(list2[j])
                j+=1
            elif j >= len(list2) or list1[i] < list2[j]:
                list.append(list1[i])
                i+=1
            elif list1[i] < list2[j]:
                list.append(list1[i])
                i+=1
            else:
                list.append(list2[j])
                j+=1
        return list

    def inorder(self, root: TreeNode, list: List[int]):
        if root is None:
            return
        self.inorder(root.left, list)
        list.append(root.val)
        self.inorder(root.right, list)