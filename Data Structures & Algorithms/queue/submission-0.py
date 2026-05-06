class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None

class Deque:
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = ListNode(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.length = 0

    def isEmpty(self) -> bool:
        if self.length >= 1:
            return False
        return True

    def append(self, val: int) -> None:
        newNode = ListNode(val)
        newNode.next = self.tail
        newNode.prev = self.tail.prev

        self.tail.prev.next = newNode
        self.tail.prev = newNode
        
        self.length += 1

    def appendleft(self, val: int) -> None:
        newNode = ListNode(val)
        newNode.next = self.head.next
        newNode.prev = self.head
        
        self.head.next.prev = newNode
        self.head.next = newNode
        
        self.length += 1

    def pop(self) -> int:
        if self.isEmpty():
            return -1

        val = self.tail.prev.val
        currNode = self.tail.prev.prev

        self.tail.prev.next = None
        currNode.next = self.tail

        self.tail.prev.prev = None
        self.tail.prev = currNode

        self.length -= 1
        return val

    def popleft(self) -> int:
        if self.isEmpty():
            return -1
        
        val = self.head.next.val
        currNode = self.head.next.next

        currNode.prev = self.head
        self.head.next.next = None

        self.head.next.prev = None
        self.head.next = currNode

        self.length -= 1
        return val
