# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
                
        ### BFS Approach
        result = []
        
        if not root:
            return result
        
        queue = deque()
        queue.append(root)
        
        ### BFS Approach
        while queue:
            
            max_val = float('-inf')

            ### Iterate through all nodes belonging to same level
            for i in range(len(queue)):
                node = queue.popleft()
                max_val = max(max_val, node.val) #Cache the max
                
                # Add its children to the queue
                if node.right: 
                    queue.append(node.right)
                    
                if node.left: 
                    queue.append(node.left)
                    
            # Append max value for that row to the result
            result.append(max_val)
                
        return result
            
            
            