# Time Complexity : O(N) where N is number of nodes in the Binary tree
# Space Complexity : O(N) where N is number of nodes in the Binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is None: return result
        q = deque()
        q.appendleft(root)
        
        while len(q) != 0:
            max_level = float('-inf')
            i = 0
            size = len(q)
            
            while i < size:
                node = q.pop()
                
                if node.val > max_level:
                    max_level = node.val
                    
                if node.left is not None:
                    q.appendleft(node.left)
                
                if node.right is not None:
                    q.appendleft(node.right)
                i += 1
            
            result.append(max_level)
        
        return result