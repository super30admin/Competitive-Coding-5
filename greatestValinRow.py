# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        queue = deque([root])
        res = []
        #res.append(root.val) # res =[1]
        
        while queue:
            q_size = len(queue)
            mx = float(-inf)
            for _ in range(q_size):
                node = queue.popleft() #node =1 ; node = 3; node= 5
                mx = max(mx,node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right) # queue = [3,5] ; queue = 5,9,10 ; queue = 9,10
                
            res.append(mx) # res= [1,5]
        return res

#time = O(N)
#space = O(N)