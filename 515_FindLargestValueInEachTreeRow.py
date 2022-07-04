"""
Leetcode- https://leetcode.com/problems/find-largest-value-in-each-tree-row/ (submitted)
TC- O(N), SC-O(1) auxiliary DFS
Challenge-NA
Lecture-https://youtu.be/SOuhsfAe5zI
FAQ-


Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).


Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:
Input: root = [1,2,3]
Output: [1,3]


Constraints:
The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
"""
from collections import deque


class Solution:
    """
    Ideation- DFS TC- O(N), SC-O(1) auxiliary
    For every node in ith level of the tree. Pick maximum of result[i].
    """

    def largestValues(self, root):
        self.result = []
        if not root:
            return []
        self.helper(root, 0)
        return self.result

    def helper(self, root, level):
        if root is None:
            return
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = max(self.result[level], root.val)
        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)
    """
    Ideation- BFS TC- O(N), SC-O(N)
    Same idea as DFS approach
    """

    def largestValues1(self, root):
        q = deque()
        q.append(root)
        result = []
        if not root:
            return result
        while q:
            size = len(q)
            max_ = -2 ** 31
            for _ in range(size):
                curr = q.popleft()
                max_ = max(max_, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            result.append(max_)
        return result
