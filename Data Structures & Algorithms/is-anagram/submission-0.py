class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)): return False
        
        new_s = sorted(s)
        new_t = sorted(t)

        for i in range(len(new_s)):
            if(new_s[i] != new_t[i]):
                return False
        return True