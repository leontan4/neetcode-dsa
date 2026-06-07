class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        
        n = len(s)
        if n <= 0:
            return 0

        L = 0
        maxL = float("-inf")

        for R in range(n):
            seen[s[R]] = seen.get(s[R], 0) + 1

            while seen.get(s[R]) > 1:
                seen[s[L]] -= 1

                if seen[s[L]] == 0:
                    del seen[s[L]]
                L += 1

            maxL = max(maxL, R - L + 1)

        return maxL

