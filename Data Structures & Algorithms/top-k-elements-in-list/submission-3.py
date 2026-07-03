class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)

        for num in nums:
            freq[num] += 1

        min_heap = []
        for num, count in freq.items():
            if len(min_heap) < k:
                heapq.heappush(min_heap, (count, num))
            elif min_heap[0][0] < count:
                heapq.heappop(min_heap)
                heapq.heappush(min_heap, (count, num))

        res = []
        while min_heap:
            res.append(heapq.heappop(min_heap)[1])

        return res