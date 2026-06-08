# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # dummy = ListNode(-1)
        # dummy.next = head
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        slow = self.reverseList(slow)
        fast = head
        
        # [2,4,6,8,10]
        # [2,4,6]
        #    f 
        # [10,8,6]
        #     s  
        # [2 -> 10 -> 4]
        while fast.next and slow.next:
            new_fast = fast.next
            fast.next = slow
            new_slow = slow.next
            slow.next = new_fast
            fast = new_fast
            slow = new_slow

        #     new_slow = slow.next
        #     slow.next = new_fast
        #     slow = new_slow

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        prev = None

        while head:
            new_node = head.next
            head.next = prev
            prev = head
            head = new_node

        return prev
