# from collections import deque
class MovingAverage:

    def __init__(self, size: int):
        self.size = size
        self.total = 0
        self.dq = deque()

    def next(self, val: int) -> float:
        if len(self.dq) >= self.size:
            to_remove = self.dq.popleft()
            self.total -= to_remove
        
        self.dq.append(val)
        self.total += val
        return self.total / len(self.dq)