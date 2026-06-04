class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        m = len(s)
        n = len(t)

        L = 0
        R = 0

        while L < m and R < n:
            if s[L] == t[R]:
                L += 1
            R += 1
        
        return L == m