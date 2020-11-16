# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# Using BFS find the largest at each level. Use size and go into for loop

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
        res = []
        
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            maximum = float('-inf');
            for i in range(size):
                cur = q.popleft()
                maximum = max(maximum, cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            res.append(maximum)
        
        return res
                
                

                
            
        