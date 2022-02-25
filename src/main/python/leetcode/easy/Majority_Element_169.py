# 169. Majority Element
# https://leetcode.com/problems/majority-element/
# Given an array nums of size n, return the majority element.
# The majority element is the element that appears more than floor(n / 2) times.
# You may assume that the majority element always exists in the array.
from typing import List
from collections import Counter
class Solution:
    def majorityElement_slow(self, nums: List[int]) -> int:
        max_occurence = 0
        max_num = nums[0]
        counter=Counter()
        for num in nums:
            counter[num] += 1
            if counter[num] > max_occurence:
                max_occurence = counter[num]
                max_num = num
        return max_num

    # Approach : Boyer-Moore Voting Algorithm
    def majorityElement(self, nums: List[int]) -> int:
        majority_element = nums[0]
        sum = 0
        for idx,val in enumerate(nums):
            if val == majority_element:
                sum += 1
            else:
                sum -= 1
            if sum == 0:
                majority_element = nums[idx+1]
        return majority_element