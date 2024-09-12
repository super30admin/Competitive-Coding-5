# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []     
        
        ans = []
        
        qu = collections.deque([root])
        
        while qu:
            max_val = -math.inf
            for i in range(len(qu)):
                node = qu.popleft()
                
                if node.val > max_val:
                    max_val = node.val

                if node.left:
                    qu.append(node.left)
                
                if node.right:
                    qu.append(node.right)
                
            ans.append(max_val)    
        return ans