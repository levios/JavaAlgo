import unittest
from typing import List

# 941. Valid Mountain Array
# https://leetcode.com/problems/valid-mountain-array/
# Given an array of integers arr, return true if and only if it is a valid mountain array.
class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        if len(arr) < 3:
            return False
        upHill=False
        up=True
        for i in range(1,len(arr)):
            if up:
                if arr[i] < arr[i-1]:
                    up=False
                elif arr[i] == arr[i-1]:
                    return False
                else:
                    upHill=True
            elif not up and arr[i] >= arr[i-1]:
                    return False
        return upHill and not up