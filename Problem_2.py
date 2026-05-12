# https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def largestValues(self, root):
        result = []
        if not root:
            return result
        q = deque()
        q.append(root)
        while q:
            qs = len(q)
            temp = -2147483649
            for _ in range(qs):
                front = q.popleft()
                temp = max(temp, front.val)
                if front.left:
                    q.append(front.left)
                if front.right:
                    q.append(front.right)
            result.append(temp)

        return result
