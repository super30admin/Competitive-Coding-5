"""
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 
"""
# Time Complexity : O(n)) 
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from typing import List
from collections import deque

# Because we need to go through all levels, it does not matter if we use bfs or dfs
# BFS level order traversal goes through all elements on each level first, hence using bst
class Solution:

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:

        # base
        if not root:
            return []

        # logic
        resuult = []
        q = deque([])
        q.append(root)

        while q:
            maxVal = float("-inf")
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                maxVal = max(maxVal, curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

                
                result.append(maxVal)
            
            return result


    """
        result = [TreeNode]
        self.helper(root, result, 0)
        
        return result
    
    def helper(self, root, result, level):
        
        if not root:
            return
        
        if level == len(result):
            result.append(root.val)
        else:
            result[level] = max(result[level], root.val)
            
        self.helper(root.left, result, level+1)
        self.helper(root.right, result, level+1)

        """

