# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return []
        
        result = []
        queue = deque([root])
        while queue:
            maxVal = float('-inf')
            for _ in range(len(queue)):
                rootPopped = queue.popleft()
                maxVal = max(rootPopped.val, maxVal)
                if rootPopped.left:
                    queue.append(rootPopped.left)
                if rootPopped.right:
                    queue.append(rootPopped.right)
            result.append(maxVal)
        return result
                
                
                
                
        
