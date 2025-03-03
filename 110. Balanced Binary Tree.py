#space: O(h)
#time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balance= self.dfs(root,0)
        return balance[0]

    def dfs(self,root,h):
        if root is None:
            return [True,0]
        left= self.dfs(root.left, h+1)
        right= self.dfs(root.right, h+1)
        balanced= left[0] and right[0] and (abs(left[1]-right[1]) <=1)
        return [balanced, (max(right[1], left[1]) + 1)]


        
