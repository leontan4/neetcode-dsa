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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0) - 1;
    }

    public int dfs(TreeNode root, int level){
        if(root == null){
            return 1;
        }

        int left = dfs(root.left, level) + 1;
        int right = dfs(root.right, level) + 1;
        
        return Math.max(right, left);

    }
}
