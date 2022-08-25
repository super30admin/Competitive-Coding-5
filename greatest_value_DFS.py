# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode: Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        self.i = 0
        
        # check if root is null, then return an empty list
        if not root:
            return self.res
        # call helper function to start dfs
        self.helper(root, 0)
        return self.res
    
    def helper(self, root, depth):
      # if we reach leaf node, then just return
        if not root:
            return
        # at each call, we calculate the size of res to cover all the element at each level
        n = len(self.res)
        
        # if we do not have any element at the depth, we simply add it to the res
        if depth == n:
            self.res.append(root.val)
        # store the max value at each depth
        self.res[depth] = max(root.val,self.res[depth])
        
        # recursively call the tree on left and right subtree to do the same
        self.helper(root.left, depth+1)
        
        self.helper(root.right, depth+1)
        
    
