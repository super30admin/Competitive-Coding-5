"""
Problem: 515. Find Largest Value in Each Tree Row
Leetcode: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
Solution:
    - DFS iterative solution using stack
    - do depth first search traversal
    - Add the children to the stack that are valid for the next round.
Time Complexity: O(n), where n is the number of nodes in tree
Space Complexity: O(h), where h is the height of the tree
Did this code successfully run on Leetcode : Yes
"""


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
        # By default add root to the stack with depth zero
        stack = [(root, 0)]

        while stack:
            node, depth = stack.pop()

            if len(result) == depth:
                result.append(node.val)
            else:
                result[depth] = max(result[depth], node.val)

            if node.left:
                stack.append((node.left, depth + 1))
            if node.right:
                stack.append((node.right, depth + 1))
        return result