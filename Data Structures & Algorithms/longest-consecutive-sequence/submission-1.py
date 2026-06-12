class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = [0] * 1001
        
        for num in nums:
            seen[num] += 1

        max_count = 0
        count = 0
        for index, num in enumerate(seen):
            if num >= 1:
                count += 1
            else:
                count = 0
            max_count = max(max_count, count)
            # print(f"{index}: {num}")
        return max_count