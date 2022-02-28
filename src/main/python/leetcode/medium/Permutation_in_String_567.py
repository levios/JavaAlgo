from collections import Counter
# 567. Permutation in String
# https://leetcode.com/problems/permutation-in-string/
# return true if one of s1's permutations is the substring of s2.
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        l, l2=len(s1), len(s2)
        if l2 < l:
            return False
        s1C=Counter()
        for char in s1:
            s1C[char] += 1
        s2C=Counter()
        for i in range(l):
            s2C[s2[i]] += 1
        if s1C == s2C:
            return True
        for idx, char in enumerate(s2[l:]):
            s2C[char] += 1
            s2C[s2[idx]] -= 1
            if s2C[s2[idx]] == 0:
                del s2C[s2[idx]]
            if s1C == s2C:
                return True
        return False
if __name__ == '__main__':
    x=Solution()
    print(x.checkInclusion('ab', 'eidbaooo'))