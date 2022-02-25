
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __str__(self):
        return str(self.val) + " [" + str(self.neighbors) + "]"