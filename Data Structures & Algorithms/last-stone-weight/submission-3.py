class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        max_heap = []

        for num in stones:
            heapq.heappush(max_heap, -num)

        while len(max_heap) > 1:
            x = -(heapq.heappop(max_heap))
            y = -(heapq.heappop(max_heap))

            total = abs(x - y)
            heapq.heappush(max_heap, -total)
        
        return -(max_heap[0])

