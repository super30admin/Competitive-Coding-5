# Time Complexity : O(n)
# Space Complexity : O(diameter)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Level Order traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = deque()

        if root is None:
            return res

        q.append(root)
        while q:
            size = len(q)
            maxVal = -float('inf')
            for _ in range(size):
                curr = q.popleft()
                maxVal = max(maxVal, curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            res.append(maxVal)
        
        return res
        
