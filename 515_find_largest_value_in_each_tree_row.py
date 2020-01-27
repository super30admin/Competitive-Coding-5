# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
from math import inf


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        """
            // Time Complexity : O(n)
                'n' the number of nodes
            // Space Complexity : O(n)
            // Three line explanation of solution in plain english:
                - Level order traversal
                - Keep track of max value at each level
                - Append the max value after each level to result list
        """
        result = []

        # edge case
        if not root:
            return result

        # level order traversal
        queue = deque()
        queue.append(root)
        max_val = -inf
        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                max_val = max(max_val, cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            result.append(max_val)
            max_val = -inf
        return result
