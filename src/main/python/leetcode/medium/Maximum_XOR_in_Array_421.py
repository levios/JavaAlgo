
from typing import List
from collections import deque
from TreeNode import TreeNode
# 421. Maximum XOR of Two Numbers in an Array
# https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
# TODO

class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        # build binary tree
        root=TreeNode(0)
        queue = deque(root)
        for x in range(32): # levels
            if queue.count() > 1:
                t = queue.pop()
                left=TreeNode(0)
                right=TreeNode(0)
                t.left = left
                t.right = right
                queue.append(left)
                queue.append(right)
        # build binary tree
        for n in nums:
            node = root
            xor=root # also track xor value
            xor_value=0
            lvl=0
            n.bit_length()-1
            while n > 0:
                if n%2 == 0:
                    if node.left is None:
                        node.left=TreeNode(0)

                    node=node.left
                else:
                    if node.right is None:
                        node.right=TreeNode(1)
                    node=node.right
                n /= 2
        # check for 'inverse' =>
        # TODO




if __name__ == '__main__':
    print(Solution().findMaximumXOR([]))