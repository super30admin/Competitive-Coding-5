# Time Complexity = O(n)
# Space Compelxity = O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> list[int]:
        if root == None:
            return []
        
        result = []
        q = []
        q.append(root)

        
        while q:
            size = len(q)
            maxV = -sys.maxsize -1
            
            for i in range(size):
                curr = q.pop(0)
                
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
        
                    
                maxV = max(maxV, curr.val)
            
            result.append(maxV)
        
        return result
                
            