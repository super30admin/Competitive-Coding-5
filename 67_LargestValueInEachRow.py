# Accepted on leetcode(515)
# time - O(N), space O(N)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def largestValues(self, root: TreeNode):
        # edge case
        if root is None: return []
        result = []
        queue = []
        queue.append(root)
        # BFS using queue, on each level we are taking the max of values and appending it to result.
        while queue:
            temp = []
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                temp.append(curr.val)
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
            result.append(max(temp))
        return result