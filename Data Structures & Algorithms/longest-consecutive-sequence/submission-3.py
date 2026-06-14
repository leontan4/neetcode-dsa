class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = [0] * 1001
        nums.sort()
        if len(nums) <= 0:
            return 0

        # for num in nums:
        #     seen[abs(num)] += 1

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

        # for index, num in enumerate(seen):
        #     if num >= 1:
        #         count += 1
        #     else:
        #         count = 0
        #     max_count = max(max_count, count)
        #     print(f"{index}: {num}")
        return max_count
