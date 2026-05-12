# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes

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
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        res=[]
        q=deque([root])

        if root is None: return res

        while q:
            level=len(q)
            max_l=float('-inf')
            for i in range(level):
                node=q.popleft()
                max_l = max(max_l,node.val)

                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            res.append(max_l)
        
        return res


        