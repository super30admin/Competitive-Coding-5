# 515. Find Largest Value in Each Tree Row

# Approach: Regular BFS, add max value at each level to the resultant array


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
        
        q = collections.deque()
        
        q.append(root)
        
        res = []
        
        while q:
            
            local = []
            
            for i in range(len(q)):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
                local.append(curr.val)
            
            res.append(max(local)) #O(n) #O(N) n = height of the tree and m is the width 
        
        return res
            
# Time complexity: O(N)
# Space complexity: O(N)
# Accepted on Leetcode: Yes
    
