from typing import List
from collections import Counter
# 560. Subarray Sum Equals K
# https://leetcode.com/problems/subarray-sum-equals-k/
# Given an array of integers nums and an integer k,
# return the total number of continuous subarrays whose sum equals to k.
# -1000 <= nums[i] <= 1000
# -10^7 <= k <= 10^7

# this is possible in O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sum_map=Counter()
        counter=0
        sum=0
        for i, num in enumerate(nums):
            sum+=num
            sum_map[sum] += 1
            if num == k:
                counter += 1
        for s in sum_map:
            if k-s in sum_map:
                counter += (sum_map[s] * sum_map[k-s])
                sum_map[s] = 0
            if s == k:
                counter += sum_map[s]
        return counter


if __name__ == '__main__':
    x=Solution()
    print(x.subarraySum([1,1,1], 2)) # 2
    print(x.subarraySum([1,2,3], 3)) # 2
    print(x.subarraySum([2,1,1], 2)) # 2
    print(x.subarraySum([2,-1,-1], 2)) # 1
