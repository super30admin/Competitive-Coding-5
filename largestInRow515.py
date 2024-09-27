# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Approach BFS  

import math
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        
        result = []
        # temporary dictionary for adding the max at given level
        res_d = {}
        queue = []
        level = 0

        queue.append(root)
        result.append(root.val)
        
        while(queue):
            size = len(queue)
            max_level = - math.inf
            level += 1
            for i in range(size):
                current = queue.pop(0)
                
                
                if current.left:
                    if current.left.val > max_level:
                        max_level = current.left.val
                        
                        res_d[level] =  max_level
                    queue.append(current.left)
                if current.right:
                    if current.right.val > max_level:
                        max_level = current.right.val
                        res_d[level] = max_level
                    queue.append(current.right)
            
        for key in res_d:
            result.append(res_d[key])   
        print(result)
        return result
                        
                        
                

        
        