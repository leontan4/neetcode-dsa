/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);

            maxHeap.offer(curr.val);
        }

        while(!maxHeap.isEmpty() && k > 1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.peek();
    }
}
