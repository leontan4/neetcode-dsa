import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        ss = re.sub(r'[^a-zA-Z0-9\s]', '', s).replace(" ", "").lower()
        L = 0
        R = len(ss) - 1

        while L < R:
            if ss[L] != ss[R]:
                return False
            L += 1
            R -= 1
        return True