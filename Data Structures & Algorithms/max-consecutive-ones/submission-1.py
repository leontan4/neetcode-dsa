class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        n = len(nums)
        L = 0
        max_freq = 0

        for R in range(n):
            
            if(nums[R] == 0):
                if(R < n):
                    L = R + 1
            max_freq = max(max_freq, R - L + 1)

        # [1,0,1,1,0,0]
        #            R
        #            L
        return max_freq

