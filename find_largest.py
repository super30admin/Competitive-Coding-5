# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        queue = deque([root,])
        ans = []
        
        if root is None:
            return ans
        
        while queue:
            
            max_curr = float('-inf')
            
            for _ in range(len(queue)):
                
                node = queue.popleft()
                max_curr = max(node.val, max_curr)
                
                if node.left:
                    queue.append(node.left)
                    
                if node.right:
                    queue.append(node.right)
                    
            ans.append(max_curr)
            
            
        return ans
        
        
        
