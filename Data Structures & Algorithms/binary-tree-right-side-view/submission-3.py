# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        dq = deque()
        res = []

        if not root:
            return res

        dq.append(root)

        while dq:
            level_size = len(dq)

            for index in range(level_size):
                curr = dq.popleft()

                if curr.left:
                    dq.append(curr.left)
                if curr.right:
                    dq.append(curr.right)

                if index == level_size - 1:
                    res.append(curr.val)
        return res
