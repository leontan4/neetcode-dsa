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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode curr : lists) {
            while(curr != null){
                pq.offer(curr.val);
                curr = curr.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            int elem = pq.poll();

            curr.next = new ListNode(elem);
            curr = curr.next;
        }
        return dummy.next;
    }
}
