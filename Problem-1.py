"""
Approach:  1) BFS 2) DFS
for both
TC: O(n)
SC: O(n)
"""

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Approach : BFS
    """
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result


        q = deque()
        q.append(root)

        while q:
            size = len(q)
            level_max = float('-inf')
            for i in range(size):
                curr = q.popleft()
                if curr.val > level_max:
                    level_max = curr.val
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            result.append(level_max)
        return result
    """

    # Approach : DFS
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result

        self.dfs(root, 0, result)
        return result

    def dfs(self, root, level, result):
        # base
        if not root: return

        # logic
        if level == len(result):
            result.append(root.val)
        else:
            result[level] = max(root.val, result[level])

        self.dfs(root.left, level + 1, result)
        self.dfs(root.right, level + 1, result)



