# Definition for a binary tree node.
from __future__ import annotations
from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def create(list: List[int]) -> Optional[TreeNode]:
        if len(list) == 0:
            return None
        idx=0
        root=TreeNode(list[idx])
        nodes=deque()
        nodes.append(root) # append right
        while len(nodes) > 0 and idx < len(list)-2:
            # pop top element
            node=nodes.pop()

            idx += 1
            if list[idx] is None:
                node.left=None
            else:
                left=TreeNode(list[idx])
                node.left=left
                nodes.append(left)

            idx += 1
            if list[idx] is None:
                node.right=None
            else:
                right=TreeNode(list[idx])
                node.right=right
                nodes.append(right)

        return root

TreeNode.create = staticmethod(TreeNode.create)
