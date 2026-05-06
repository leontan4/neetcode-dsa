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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return count;

        int currMax = Integer.MIN_VALUE;
        dfs(root, currMax);
        return count;
    }

    public void dfs(TreeNode root, int currMax){
        if(root == null) return;

        if(root.val >= currMax){
            count++;
        }
        
        currMax = Math.max(currMax, root.val);
        if(root.left != null){
            dfs(root.left, currMax);
        }

        if(root.right != null){
            dfs(root.right, currMax);
        }
    }
}