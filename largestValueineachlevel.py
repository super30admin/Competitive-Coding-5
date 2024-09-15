# Time Complexity : O(row*col)
# Space Complexity : O(row*col)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        q = [root]
        if root is None:
            return []
        while q:
            size = len(q)
            curr_max = float('-inf')
            for i in range(size):
                node = q.pop(0)
                curr_max = max(curr_max, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            ans.append(curr_max)
        return ans
                
                
        