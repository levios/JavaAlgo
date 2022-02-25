from typing import List
# 127. Word Ladder
# https://leetcode.com/problems/word-ladder/
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        q= {beginWord}
        counter=1
        while len(q) > 0:
            q2=set()
            for current in q:
                if current == endWord:
                    return counter
                for word in wordList:
                    if self.isRelated(word, current):
                        q2.add(word)
            wordList = [item for item in wordList if item not in q2]
            counter += 1
            q=q2
        return 0

    def isRelated(self, word1, word2) -> bool:
        diff = 0
        for idx, ch in enumerate(word1):
            if not ch == word2[idx]:
                if diff == 1:
                    return False
                diff += 1
        return True

if __name__ == '__main__':
    x=Solution()
    print(x.ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]))
    print(x.ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]))