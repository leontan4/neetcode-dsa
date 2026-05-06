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
    ListNode curr;
    int sum;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        curr = dummy;

        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;

            int digit = sum % 10;
            sum -= digit;
            sum /= 10;

            curr.next = new ListNode(digit);

            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum += l1.val;

            int digit = sum % 10;
            sum -= digit;
            sum /= 10;

            curr.next = new ListNode(digit);

            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum += l2.val;

            int digit = sum % 10;
            sum -= digit;
            sum /= 10;

            curr.next = new ListNode(digit);

            curr = curr.next;
            l2 = l2.next;
        }

        if(sum > 0){
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
