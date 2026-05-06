import re

class Solution:
    def isPalindrome(self, s: str) -> bool:

        cleaned = list(re.sub(r'[^a-zA-Z0-9]', '', s).lower())
        start, end = 0, len(cleaned)-1

        while(start <= end):
            if(cleaned[start] != cleaned[end]):
                return False;
            
            start += 1
            end -= 1
        return True
        