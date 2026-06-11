class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.min_heap = []

        for num in nums:
            if len(self.min_heap) < k:
                heapq.heappush(self.min_heap, num)
            elif self.min_heap[0] <= num:
                heapq.heappop(self.min_heap)
                heapq.heappush(self.min_heap, num)

    def add(self, val: int) -> int:
        if not self.min_heap:
            heapq.heappush(self.min_heap, val)
        elif self.min_heap[0] <= val:
            heapq.heappop(self.min_heap)
            heapq.heappush(self.min_heap, val)
        return self.min_heap[0]