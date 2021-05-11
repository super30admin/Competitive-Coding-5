from collections import deque 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        result = []
        q = deque()
        
        q.append(root)
        
        while q:
            
            max_element = float('-inf')
            for i in range(len(q)):
                node = q.popleft()
                max_element = max(node.val,max_element)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)                
                
            result.append(max_element)
        
        return result
