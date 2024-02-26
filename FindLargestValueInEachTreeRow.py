'''
TC: O(n) - since we go through every node in the tree
SC: O(n) - m being the leaf nodes - O(n/2) ~ O(n)
'''
# Definition for a binary tree node.
from collections import deque
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res
        q = deque()
        q.append((root))
        while q:
            l = len(q)
            maxEle = -float("inf")
            for i in range(l):
                node = q.popleft()
                maxEle = max(maxEle, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(maxEle)
        return res