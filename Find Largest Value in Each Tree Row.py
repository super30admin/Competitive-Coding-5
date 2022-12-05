# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import math
from queue import Queue
from collections import defaultdict

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
    
        # DFS
        if not root:
            return None
        res = defaultdict(lambda: -math.inf)
        
        def dfs(root, level):
            if not root:
                return
            
            if root.val > res[level]:
                res[level] = root.val
            
            dfs(root.right, level+1)
            dfs(root.left, level+1)
        
        dfs(root, 0)
        values = [j for i, j in res.items()] 
        return values
    
        # BFS
        if not root:
            return None
        
        
        q = Queue()
        q.put(root)
        res = []
       
        while not q.empty():
            
            size = q.qsize()
            max = -math.inf 
            
            for i in range(size):
                curr = q.get()
                if curr.val > max:
                    max = curr.val
                    
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
            
            res.append(max)
            
        return res
