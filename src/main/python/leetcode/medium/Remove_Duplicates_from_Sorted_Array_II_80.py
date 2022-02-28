from typing import List
from collections import Counter

# 80. Remove Duplicates from Sorted Array II
# https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
# nums sorted in non-decreasing order
# remove some duplicates in-place such that each unique element appears at most twice
# the result be placed in the first part of the array num
# Return k after placing the final result in the first k slots of nums


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        counter=Counter()
        duplicates=0
        for index, value in enumerate(nums):
            if value in counter and counter[value] == 2:
                duplicates += 1
            else:
                counter[value] += 1
                nums[index-duplicates] = value
        return n-duplicates


