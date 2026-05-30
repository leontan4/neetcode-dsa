class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        n = len(nums)
        L = 0

        for R in range(n):
            if(nums[R] != val):
                nums[L] = nums[R]
                L += 1
        # [2,2,2,3]
        #  R
        #  L
        return L