class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        min_heap = []

        for num in nums:
            heapq.heappush(min_heap, num)

        res = []
        while min_heap:
            res.append(heapq.heappop(min_heap))

        return res