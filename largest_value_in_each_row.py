# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# Approach
# DFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        
        def dfs(node, level):
            if not node:
                return
            if len(result) < level:
                result.append(node.val)
            else:
                result[level-1] = max(result[level-1], node.val)
            dfs(node.left, level+1)
            dfs(node.right, level+1)
            
        dfs(root, 1)
        return result

# Approach
# BFS

# TC: O(N)
# SC: O(N)

import math
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = deque([root])
        result = []
        # while q
        while q:
            n = len(q)
            _max = -math.inf
            for _ in range(n):
                node = q.popleft()
                _max = max(_max, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(_max)
        return result