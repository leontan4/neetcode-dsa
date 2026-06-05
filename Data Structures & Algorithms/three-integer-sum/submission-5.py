class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []

        # [-4, -1, -1, 0, 1, 2]
        #       i   j        k

        for i in range(len(nums)):
            j = i + 1
            k = n - 1
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            while j < k:
                sum = nums[i] + nums[j] + nums[k]
                if sum == 0:
                    res.append([nums[i], nums[j], nums[k]])

                    j += 1
                    k -= 1

                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
                    while j < k and nums[k] == nums[k + 1]:
                        k -= 1
                elif sum > 0:
                    k -= 1
                elif sum < 0:
                    j += 1
        return res
