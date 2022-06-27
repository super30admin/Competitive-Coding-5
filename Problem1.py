'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from collections import deque
from sys import maxsize
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> list[int]:
        # null case
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while len(queue) != 0:
            lvlMax = -maxsize - 1
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                if curr.val > lvlMax:
                    lvlMax = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(lvlMax)
        return result