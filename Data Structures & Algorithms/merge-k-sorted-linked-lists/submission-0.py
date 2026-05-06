# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(-1)

        for k in range(len(lists)):
            curr = dummy

            self.merge(curr, dummy.next, lists[k])

        return dummy.next


    def merge(self, curr, l1: List[Optional[ListNode]], l2: List[Optional[ListNode]]) -> None:
        while l1 and l2:
            if l1.val <= l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
            
        curr.next = l2 if not l1 else l2