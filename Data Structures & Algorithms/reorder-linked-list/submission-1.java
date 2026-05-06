/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;
        head = slow;
        
        while(slow != null && fast != null){
            ListNode newFast = fast.next;
            fast.next = slow;

            ListNode newSlow = slow.next;
            slow.next = newFast;
            fast = newFast;
            slow = newSlow;
        }
    }

    // [0, 1, 2, 3, 4, 5, 6]

    // [0,1,2,3]
    // [6,5,4]
    public ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode newNode = head.next;
            head.next = prev;
            prev = head;
            head = newNode;
        }
        return prev;
    }
}
