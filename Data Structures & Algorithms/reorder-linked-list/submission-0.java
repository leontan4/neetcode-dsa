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
        

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow;
        slow = reverse(slow.next);
        temp.next = null;

        dummy = dummy.next;
        fast = head.next;

        while(slow != null && fast != null){
            dummy.next = slow;
            slow = slow.next;
            dummy = dummy.next;

            dummy.next = fast;
            fast = fast.next;
            dummy = dummy.next;
        }

        while(slow != null){
            dummy.next = slow;
            slow = slow.next;
            dummy = dummy.next;
        }

        while(fast != null){
            dummy.next = fast;
            fast = fast.next;
            dummy = dummy.next;
        }
    }

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
