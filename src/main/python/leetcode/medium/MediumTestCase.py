import unittest
from leetcode.TreeNode import TreeNode

from leetcode.medium.All_Elements_in_Two_Binary_Search_Trees_1305 import Solution as Leetcode_1305

class MyTestCase(unittest.TestCase):

    def test_Leetcode_1305(self):
        x = Leetcode_1305()
        print('All_Elements_in_Two_Binary_Search_Trees_1305')
        self.assertEqual(x.getAllElements(TreeNode(2, TreeNode(1)), TreeNode(3, None, TreeNode(4))), [1,2,3,4])


if __name__ == '__main__':
    unittest.main()
