"""
Problem: 515. Find Largest Value in Each Tree Row
Leetcode: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
Solution:
    - BFS iterative solution using queue
    - do level order traversal, at each level collect the max node.
    - Append only the children that are valid for the next round.
Time Complexity: O(n), where n is the number of nodes in tree
Space Complexity: O(n), to store current row and next row nodes in a queue
Did this code successfully run on Leetcode : Yes
"""


from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        result = []
        queue = deque([root])
        while queue:
            qsize = len(queue)
            level_max = float('-inf')
            for i in range(qsize):
                node = queue.popleft()
                level_max = max(level_max, node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(level_max)
        return result

