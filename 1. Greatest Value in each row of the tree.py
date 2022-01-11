# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    # Time Complexity : O(n) as we're traversing the tree in level order.
    # Space Complexity : O(n) for the queue.
    def largestValues(self, root):
        q = deque()
        if root:
            q.append(root)
        result = []

        while len(q):
            qLen = len(q)
            x = float('-inf')
            for _ in range(qLen):
                node = q.popleft()

                x = max(x, node.val)
                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            result.append(x)
        return result