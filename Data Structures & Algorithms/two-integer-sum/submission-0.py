class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        pair = {}

        for i in range(n):
            y = nums[i]
            x = target - y

            if(x not in pair):
                pair[y] = i
            else:
                return [pair[x], i]
        return []

# target = 7, y = 3, x = 4
# target = 7, y = 4, x = 3

# {3 : 0}