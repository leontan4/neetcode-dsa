class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        count = [0] * 500001

        for num in nums:
            count[num] += 1

        res = []

        for i in range(len(count)):
            while count[i] > 0:
                res.append(i)
                count[i] -= 1
        
        return res