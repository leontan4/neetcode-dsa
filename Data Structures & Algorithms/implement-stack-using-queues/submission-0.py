class MyStack:

    def __init__(self):
        self.dq = deque()

    def push(self, x: int) -> None:
        self.dq.append(x)

    def pop(self) -> int:
        if len(self.dq) > 0:
            return self.dq.pop()
        return None

    def top(self) -> int:
        if len(self.dq) > 0:
            return self.dq[-1]
        return None

    def empty(self) -> bool:
        if len(self.dq) <= 0:
            return True
        return False


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()