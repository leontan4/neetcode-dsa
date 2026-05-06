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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < left; i++) {
            if(slow != curr){
                curr = curr.next;
            }
            slow = slow.next;
        }

        for (int i = left; i < right; i++) {
            ListNode fast = slow.next;
            slow.next = fast.next;
            fast.next = curr.next;
            curr.next = fast;
        }

        return dummy.next;
    }
}