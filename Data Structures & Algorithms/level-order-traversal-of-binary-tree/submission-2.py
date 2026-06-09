# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        dq = deque()

        dq.append(root)

        while dq:
            nodes = []
            for _ in range(len(dq)):

                curr = dq.popleft()

                if curr.left:
                    dq.append(curr.left)
                if curr.right:
                    dq.append(curr.right)
                nodes.append(curr.val)
            res.append(nodes)
        return res