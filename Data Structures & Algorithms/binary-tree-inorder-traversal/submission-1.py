# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        res = []
        self.dfs(root, res)
        return res

    def dfs(self, root: Optional[TreeNode], res: List[int]) -> None:
        if root is None:
            return
        
        if root.left:
            self.dfs(root.left, res)
        res.append(root.val)
        if root.right:
            self.dfs(root.right, res)