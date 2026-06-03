class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        L = 0
        R = len(nums) - 1

        while L < R:
            total = nums[L] + nums[R]

            if total == target:
                return [L + 1, R + 1]

            if total < target:
                L += 1
            else:
                R -= 1

        return [-1, -1]
