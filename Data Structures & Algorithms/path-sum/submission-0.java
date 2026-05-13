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

class Pair{
    public TreeNode node;
    public int currSum;

    Pair(TreeNode node, int currSum){
        this.node = node;
        this.currSum = currSum;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, targetSum - root.val));
        
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;

            if(node.right != null){
                stack.push(new Pair(node.right, pair.currSum - node.right.val));
            }
            
            if(node.left != null){
                stack.push(new Pair(node.left, pair.currSum - node.left.val));
            }

            if(node.left == null && node.right == null && pair.currSum == 0) {
                return true;
            }
        }
        return false;
    }
}