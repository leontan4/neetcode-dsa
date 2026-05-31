class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.split(" ")
        print(words)

        for i in range(len(words) - 1, -1, -1):
            if len(words[i]) >= 1:
                return len(words[i])
        return 0
