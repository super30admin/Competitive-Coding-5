# Time Complexity = O(n) | Space Complexity = O(n/2)

from collections import deque
import math
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> list[int]:
        result = []
        if root is None: return result

        queue = deque()
        queue.append(root)

        while len(queue) != 0:
            size = len(queue)
            temp = -math.inf
            for i in range(size):
                curr = queue.popleft()
                temp = max(temp, curr.val)

                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            result.append(temp)

        return result






