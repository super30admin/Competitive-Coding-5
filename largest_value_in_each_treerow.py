# Definition for a binary tree node.
# SC : O(N)
# TC : O(N)

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        queue = [] # for levels 
        res = [] # for res
        if root != None:
            queue.append(root)
            
        while queue:
            qlen = len(queue)
            temp_max = queue[0].val
            
            for i in range(qlen):
                node = queue.pop(0) # first ele in queue 
                temp_max = max(temp_max, node.val)
                if node.left :
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            res.append(temp_max)
        
        return res
            
        
