# 133. Clone Graph
# https://leetcode.com/problems/clone-graph/
#
#
#
#
from leetcode.Node import Node
from typing import Set
class Solution:

    def cloneGraph(self, node: 'Node') -> 'Node':
        return self.cloneGraph2(node, set())

    def cloneGraph2(self, node: 'Node', stack: Set[Node]) -> 'Node':
        root = Node(val = node.val)
        for neighbor in node.neighbors:
            if not neighbor in stack:
                stack.add(root)
                root.neighbors.append(self.cloneGraph2(neighbor, stack))
            else:
                root.neighbors.append(neighbor)
        return root

if __name__ == '__main__':
    x = Solution()
    n1,n2,n3=Node(1),Node(2),Node(3)
    n1.neighbors=[n2,n3]
    n2.neighbors=[n1,n3]
    n3.neighbors=[n2,n1]
    print(x.cloneGraph(n1))