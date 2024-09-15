# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""BFS approach"""

#Accepted on Leetcode
#Time complexity - O(N) as we are visiting every node
#Space complexity - O(N) for queue


from collections import deque
import sys

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        #Edge case
        if root == None:
            return res
        q = deque()
        q.append(root)
        while len(q) > 0:
            size = len(q)
            max_val = -sys.maxsize - 1 #Setting max_val to be the machine's lowest word size
            for i in range(size):
                curr = q.popleft()
                if curr.val >= max_val:
                    max_val = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(max_val)
        return res