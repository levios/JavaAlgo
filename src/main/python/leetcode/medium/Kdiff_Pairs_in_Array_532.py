from typing import List
from collections import Counter
# 532. K-diff Pairs in an Array
# https://leetcode.com/problems/k-diff-pairs-in-an-array/
# Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        # nums.sort()
        c=Counter()
        #s=set()
        result=set()
        for idx,val in enumerate(nums):
            c[val] += 1
            #s.add(val)
        for idx,val in enumerate(nums):
            if k == 0:
                if c[val] > 1 and not val in result:
                    result.add(val)
            elif (val+k) in c:
                if not val in result:
                    result.add(val)
        return len(result)

if __name__ == '__main__':
    x=Solution()
    print(x.findPairs([3,1,4,1,5], k = 2)) # 2
    print(x.findPairs([1,2,3,4,5], k = 1)) # 4
    print(x.findPairs([1,3,1,5,4], k = 0)) # 1