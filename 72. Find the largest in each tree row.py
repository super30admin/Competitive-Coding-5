# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is None:
            return result

        q = deque()
        q.append(root)

        while q:
            maximum = -12345678
            size = len(q)

            for i in range(size):
                node = q.popleft()
                if node.val > maximum:
                    maximum = node.val
                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
            result.append(maximum)
        return result

# TC =O(n).
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
