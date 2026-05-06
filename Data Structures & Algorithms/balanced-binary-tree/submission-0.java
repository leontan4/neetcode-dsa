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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = dfs(root.left, 0);
        int right = dfs(root.right, 0);

        return Math.abs(left - right) <= 1;
    }

    public int dfs(TreeNode root, int depth){
        if(root == null) return 0;

        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);

        return Math.max(left, right) + 1;
    }
}
