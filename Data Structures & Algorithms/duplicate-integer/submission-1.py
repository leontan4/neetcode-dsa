class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums.sort()

        prev = 0
        for curr in range(1, len(nums)):
            if(nums[prev] == nums[curr]):
                return True
            prev += 1
        return False
