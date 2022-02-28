from typing import List
from collections import Counter
# 454. 4Sum II
# https://leetcode.com/problems/4sum-ii/
# Given four integer arrays, all of length n, return the number of tuples (i, j, k, l) such that:
# 0 <= i, j, k, l < n
# nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

class Solution:

    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        counter = 0
        l=Counter()
        for x in nums1:
            for y in nums2:
                l[-(x+y)] += 1
        for x in nums3:
            for y in nums4:
                counter += l[x+y]
        return counter

if __name__ == '__main__':
    s=Solution()
    print(s.fourSumCount([1,2], [-2,-1], [-1,2], [0,2]))
    print(s.fourSumCount([0,1,-1], [-1,1,0], [0,0,1], [-1,1,1]))
