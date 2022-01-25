# 520. Detect Capital
# https://leetcode.com/problems/detect-capital/
# We define the usage of capitals in a word to be right when one of the following cases holds:
# All letters in this word are capitals, like "USA".
# All letters in this word are not capitals, like "leetcode".
# Only the first letter in this word is capital, like "Google".
# Given a string word, return true if the usage of capitals in it is right.
# Constraints: 1 <= word.length <= 100
class Detect_Capital_520:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word) < 2:
            return True
        upOrLow=False # UP=True, LOW=False
        if word[0].isupper() and word[1].isupper():
            upOrLow=True
        elif word[0].islower() and word[1].isupper():
            return False
        for i in range(2, len(word)):
            if upOrLow and word[i].islower():
                return False
            if not upOrLow and word[i].isupper():
                return False
        return True

    def detectCapitalUse2(self, word: str) -> bool:
        return word in (
            word.upper(),
            word.lower(),
            word.capitalize(),
        )
