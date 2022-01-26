import unittest

from leetcode.easy.Valid_Mountain_Array_941 import Solution as Valid_Mountain_Array_941

class MyTestCase(unittest.TestCase):

    def test_Valid_Mountain_Array_941(self):
        x = Valid_Mountain_Array_941()
        print('Valid Mountain Array test')
        self.assertEqual(x.validMountainArray([1,2,3,4,5]), False)
        self.assertEqual(x.validMountainArray([1,2,3,4,5,4,3]), True)


if __name__ == '__main__':
    unittest.main()
