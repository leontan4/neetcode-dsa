class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        L = 0
        total = 0
        minL = float("inf")

        for R in range(n):
            total += nums[R]

            while total >= target:
                minL = min(minL, R - L + 1)
                total -= nums[L]
                L += 1
        return 0 if minL == float('inf') else minL