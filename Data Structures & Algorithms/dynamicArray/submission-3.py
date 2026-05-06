class DynamicArray:
    
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.pos = 0
        self.arr = [0] * self.capacity

    def get(self, i: int) -> int:
        return self.arr[i]

    def set(self, i: int, n: int) -> None:
        self.arr[i] = n

    def pushback(self, n: int) -> None:
        if(self.pos == self.capacity):
            self.resize()

        self.arr[self.pos] = n
        self.pos += 1

    def popback(self) -> int:
        if(self.pos > 0):
            self.pos -= 1
        return self.arr[self.pos]

    def resize(self) -> None:
        self.capacity = self.capacity * 2
        newArr = [0] * self.capacity

        for i in range(self.pos):
            newArr[i] = self.arr[i]

        self.arr = newArr

    def getSize(self) -> int:
        return self.pos
    
    def getCapacity(self) -> int:
        return self.capacity