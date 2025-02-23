# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        if not root:
            return res

        # dfs traversal
        def dfs(root, level):
            if not root:
                return
            
            if len(res) == level:
                res.append(root.val)
            else:
                res[level] = max(res[level], root.val)
            
            dfs(root.left, level+1)
            dfs(root.right, level+1)
        
        dfs(root, 0)

        return res