"""Approach: Use BFS to go level by level

TC O(N) as we visit each node only once.
SC O(N) as at most in a complete tree we will have N/2 elements in the queue"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # base case
        if not root:
            return
        
        # Logic
        results = []
        q = deque()
        
        q.append(root)
        
        while q:
            size = len(q)
            m = -float("inf")
            for i in range(size):
                node = q.popleft()
                m = max(m, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            results.append(m)
        
        # print(results)
        return results
        
        
        