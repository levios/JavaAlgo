from typing import List
# 525. Contiguous Array
# https://leetcode.com/problems/contiguous-array/
# Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
# nums[i] is either 0 or 1

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_len=0
        # key: count, value: index
        dict={0: -1}
        count=0
        for i in range(len(nums)):
            if nums[i] == 1:
                count +=1
            else:
                count-=1
            if count not in dict:
                dict[count] = i
            else:
                max_len=max(max_len, i-dict[count])
        return max_len
