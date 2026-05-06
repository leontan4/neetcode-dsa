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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int extra = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + extra;

            if(sum > 9){
                extra = sum / 10;
                sum %= 10;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(extra > 0){
            curr.next = new ListNode(extra);
        }
        return dummy.next;
    }
}
