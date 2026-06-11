class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        max_heap = []
        res = []
        
        for point in points:
            x = point[0]
            y = point[1]
            dist = self.eucli(x,0,y,0)

            if len(max_heap) < k:
                heapq.heappush(max_heap, (-dist, x, y))
            elif -max_heap[0][0] >= dist:
                heapq.heappop(max_heap)
                heapq.heappush(max_heap, (-dist, x, y))
                
        while max_heap:
            point = heapq.heappop(max_heap)
            x = point[1]
            y = point[2]
            res.append([x, y])
        return res
    
    def eucli(self, x1: int, x2:int, y1:int, y2:int):
        x_squared = (x1 - x2)**2
        y_squared = (y1 - y2)**2

        return math.sqrt(x_squared + y_squared)