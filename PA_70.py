#LC 515 - Find Largest Value in Each Tree Row
#Time Complexity - O(n)
#Space Complexity - O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        q = deque()
        ans = []
        def dfs(root,level):
            if not root:
                return
            if level == len(ans):
                ans.append(root.val)
            if ans[level] < root.val:
                ans[level] = root.val
            dfs(root.left,level + 1)
            dfs(root.right,level + 1)
        
        dfs(root,0)
        return ans
            