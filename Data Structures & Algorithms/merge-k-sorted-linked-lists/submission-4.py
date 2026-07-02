# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []

        for curr in lists:
            while curr:
                heapq.heappush(min_heap, curr.val)
                curr = curr.next
        dummy = ListNode(0)
        curr = dummy

        while min_heap:
            curr.next = ListNode(heapq.heappop(min_heap))
            curr = curr.next
        return dummy.next