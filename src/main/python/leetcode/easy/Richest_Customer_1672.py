from typing import List

# 1672. Richest Customer Wealth
# https://leetcode.com/problems/richest-customer-wealth/

class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        MAX=0
        for account in accounts:
            MAX=max(MAX,sum(account))
        return MAX

if __name__ == '__main__':
    x=Solution()
    print(x.maximumWealth([[1,2,3],[3,2,1]]))
    print(x.maximumWealth([[1,5],[7,3],[3,5]]))