# Time Complexity: O(n)
# Space Complexity: O(1)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        output = []
        q = deque()
        x = []
        if not root: return output
        q.append(root)
        
        while q:
            maxx = -1 * sys.maxint
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.val > maxx: maxx = curr.val
                if curr and curr.left: q.append(curr.left)
                if curr and curr.right: q.append(curr.right)
            output.append(maxx)
        return output