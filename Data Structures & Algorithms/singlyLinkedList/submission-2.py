class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = self.head
    
    # Redo - tail
    def get(self, index: int) -> int:
        pos = 0
        curr = self.head

        while (curr!= None and curr.next != None and pos < index):
            curr = curr.next
            pos += 1

        if (curr.next == None):
            return -1

        return curr.next.val

    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)
        curr = self.head

        if(curr.next != None):
            curr = self.head.next
            self.head.next = new_node
            new_node.next = curr
        else:
            self.insertTail(val)
    
    def insertTail(self, val: int) -> None:
        new_node = ListNode(val)
        curr = self.tail

        if (curr.next == None):
            curr.next = new_node
            curr = curr.next
            self.tail = curr
    
    # Redo - tail
    def remove(self, index: int) -> bool:
        pos = 0
        curr = self.head

        while(curr!= None and curr.next != None and pos < index):
            curr = curr.next
            pos += 1

        if(curr.next != None):
            curr.next = curr.next.next
            return True

        if(curr.next == None):
            self.tail = curr
        
        return False

    def getValues(self) -> List[int]:
        arr = []
        curr = self.head.next

        while(curr != None):
            arr.append(curr.val)
            curr = curr.next
        
        return arr
