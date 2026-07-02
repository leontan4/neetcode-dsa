class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        def calc(x: int, y: int):
            return abs(x - y)

        min_heap = []

        for num in arr:
            total = calc(num, x)

            if len(min_heap) < k:
                heapq.heappush(min_heap, (-total, num))
            elif -(min_heap[0][0]) > total:
                heapq.heappop(min_heap)
                heapq.heappush(min_heap, (-total, num))
        
        return sorted([num for _, num in min_heap])

        