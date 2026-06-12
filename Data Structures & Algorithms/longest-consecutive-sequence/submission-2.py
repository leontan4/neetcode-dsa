class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = [0] * 1001
        nums.sort()
        if len(nums) <= 0:
            return 0

        max_count = 1
        count = 1
        for R in range(len(nums) - 1):
            
            if nums[R] - nums[R + 1] == -1:
                count += 1
            elif nums[R] == nums[R + 1]:
                continue
            else:
                count = 1
            max_count = max(max_count, count)

        return max_count
