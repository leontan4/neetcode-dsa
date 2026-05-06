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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head;
        int n=0;
        
        while(curr != null){
            curr = curr.next;
            n++;
        }
        n = n/k;
        
        ListNode prev = dummy;
        for(int i=0; i<n; i++){
            head = prev.next;
            for(int j=0; j<k-1; j++){
                ListNode node = head.next;
                head.next = node.next;
                node.next = prev.next;
                prev.next = node;
            }
            prev = head;
        }
        
        return dummy.next;
        
    }
}
