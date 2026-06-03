class DynamicArray:
    
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.index = 0
        self.arr = [0] * capacity

    def get(self, i: int) -> int:
        if self.index > 0:
            return self.arr[i]
        return -1

    def set(self, i: int, n: int) -> None:
        if self.index > 0:
            self.arr[i] = n

    def pushback(self, n: int) -> None:
        if self.index == self.capacity:
            self.resize()

        self.arr[self.index] = n
        self.index += 1

    def popback(self) -> int:
        if self.index > 0:
            num = self.arr[self.index - 1]
            self.index -= 1
            return num
        return -1

    def resize(self) -> None:
        self.capacity *= 2
        new_arr = [0] * self.capacity

        for index in range(len(self.arr)):
            new_arr[index] = self.arr[index]
        
        self.arr = new_arr[:]

    def getSize(self) -> int:
        return self.index
    
    def getCapacity(self) -> int:
        return self.capacity
