# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#
# BFS
# TC: O(n); SC: O(n)
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def largestValues(self, root):
        if root is None:
            return []
        result = []
        queue = deque()
        queue.append(root)
        while queue:
            maxi = float('-inf')
            size = len(queue)
            for i in range(size):
                pop = queue.popleft()
                maxi = max(maxi, pop.val)
                if pop.left:
                    queue.append(pop.left)
                if pop.right:
                    queue.append(pop.right)
            result.append(maxi)
        return result


check = TreeNode(1)
check.left = TreeNode(3)
check.right = TreeNode(2)
check.left.left = TreeNode(5)
check.left.right = TreeNode(3)
check.right.right = TreeNode(9)
print(Solution().largestValues(check))


# from collections import deque
#
#
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         if root is None:
#             return []
#         result = []
#         queue = deque()
#         queue.append(root)
#         level = 0
#         while queue:
#             size = len(queue)
#             for i in range(size):
#                 pop = queue.popleft()
#                 if len(result) == level:
#                     result.append(pop.val)
#                 else:
#                     result[-1] = max(result[-1], pop.val)
#                 if pop.right:
#                     queue.append(pop.right)
#                 if pop.left:
#                     queue.append(pop.left)
#             level += 1
#         return result
#
#
# check = TreeNode(1)
# check.left = TreeNode(3)
# check.right = TreeNode(2)
# check.left.left = TreeNode(5)
# check.left.right = TreeNode(3)
# check.right.right = TreeNode(9)
# print(Solution().largestValues(check))


# DFS
# TC: O(n); SC: O(h)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.result = []
#
#     def dfs(self, root, count):
#         # base
#         if root is None:
#             return
#         # logic
#         if count == len(self.result):
#             self.result.append(float('-inf'))
#             self.result[count] = max(root.val, self.result[count])
#         else:
#             self.result[count] = max(root.val, self.result[count])
#         self.dfs(root.left, count + 1)
#         self.dfs(root.right, count + 1)
#
#     def largestValues(self, root):
#         if root is None:
#             return
#         self.dfs(root, 0)
#         return self.result
#
#
# check = TreeNode(1)
# check.left = TreeNode(3)
# check.right = TreeNode(2)
# check.left.left = TreeNode(5)
# check.left.right = TreeNode(3)
# check.right.right = TreeNode(9)
# print(Solution().largestValues(check))
