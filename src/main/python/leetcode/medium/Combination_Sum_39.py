# 39. Combination Sum
# https://leetcode.com/problems/combination-sum/
# 1 <= candidates[i] <= 200
from typing import List
import copy

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result: List[List[int]] = []
        candidates.sort()

        def backtrack(nums:List[int], current:List[int], start:int, target:int):
            if 0 == target:
                result.append(copy.deepcopy(current))
                return
            if 0 > target:
                return
            for i in range(start, len(nums)):
                current.append(nums[i])
                backtrack(nums, copy.deepcopy(current), i, target-nums[i])
                del current[-1]

        backtrack(candidates, [], 0, target)
        return result

if __name__ == '__main__':
    x=Solution()
    print(x.combinationSum(candidates = [2,3,6,7], target = 7))
    print(x.combinationSum(candidates = [2], target = 1))