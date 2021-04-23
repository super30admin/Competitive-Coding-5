# Time Complexity is O(n)
# Space Complexity is O(n), where n is the number of nodes in Tree
# Perform BFS using Queue, to perform level order traversal and compute the maximum value in each level
from collections import deque
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
        if root is None:
            return []
        output = []
        q = deque([root])
        while(q):
            size = len(q)
            currMax = -sys.maxint-1
            for i in range(size):
                curr = q.popleft()
                currMax = max(currMax,curr.val)
                if(curr.left):
                    q.append(curr.left)
                if(curr.right):
                    q.append(curr.right)
            output.append(currMax)
        return output