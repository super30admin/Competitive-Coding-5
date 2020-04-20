# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity - O(n)
#Space Complexity - O(max Depth)


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        
        queue=collections.deque()
        res=[]
        queue.append(root)
        
        while queue:
            n=len(queue)
            maxxx=float("-inf")
            
            for i in range(n):
                node=queue.popleft()
                if not node:continue
                maxxx=max(maxxx,node.val)
                queue.append(node.left)
                queue.append(node.right) 
                
            if maxxx!=float("-inf"):
                res.append(maxxx)
                
        return res

            
        