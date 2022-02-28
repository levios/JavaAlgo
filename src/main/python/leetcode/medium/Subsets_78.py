from typing import List
import copy
# 78. Subsets
# https://leetcode.com/problems/subsets/
# Given an integer array nums of unique elements, return all possible subsets (the power set).
# The solution set must not contain duplicate subsets. Return the solution in any order.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result: List[List[int]] = []
        self.backtrack(nums, [], 0, result)
        return result

    def backtrack(self,
                  nums: List[int],
                  current: List[int],
                  start:int,
                  result: List[List[int]]):
        result.append(copy.deepcopy(current))
        for idx in range(start, len(nums)):
            # copy a list
            current.append(nums[idx])
            self.backtrack(nums, copy.deepcopy(current), idx+1, result)
            current.pop(-1)

    def subsets2(self, nums):
        result = [[]]
        for num in nums:
            result += [i + [num] for i in result]
        return result

if __name__ == '__main__':
    x=Solution()
    print(x.subsets([1,2,3]))


