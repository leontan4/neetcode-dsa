class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        L = 0
        

        for R in range(len(nums)):
            if nums[L] != nums[R]:
                L += 1
                nums[L] = nums[R]
        
        return L + 1