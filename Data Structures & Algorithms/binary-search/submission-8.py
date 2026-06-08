class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        L = 0
        R = n - 1

        while L < R:
            mid = R - L // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                L = mid + 1
            else:
                R = mid - 1

        return -1

