# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)

from collections import deque


class Solution(object):
    result = []

    # DFS approach with checking for every root  and if output array length is equal to the current level
    # and if so then replace or else add as we will be replacing left side value with right side value if value is less
    def dfss(self, root, level):

        if not root:
            return

        if len(self.result) <= level:
            self.result.append(root.val)
        elif self.result[level] < root.val:
            self.result[level] = root.val

        self.dfss(root.left, level + 1)
        self.dfss(root.right, level + 1)
    # dfs driver function
    def dfsMain(self, root):
        self.result = []
        if not root:
            return self.result
        self.dfss(root, 0)
        return self.result

    # BFS approach add root in queue and until current level
    # is done get the element and compare and add it to the result list
    def bfs(self, root):
        result = []
        q = deque()
        if not root:
            return result
        q.append(root)

        result.append(root.val)

        while q:
            size = len(q)
            max_numb = -float("inf")
            for i in range(size):
                c = q.popleft()

                if c.left:
                    q.append(c.left)
                    if max_numb < c.left.val:
                        max_numb = c.left.val

                if c.right:
                    q.append(c.right)
                    if max_numb < c.right.val:
                        max_numb = c.right.val
            if max_numb != -float("inf"):
                result.append(max_numb)

        return result

    def largestValues(self, root):
        return self.dfsMain(root)

        """
        :type root: TreeNode
        :rtype: List[int]
        """
