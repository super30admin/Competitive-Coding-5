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
        while queue:
            temp = float('-inf')
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if temp < curr.val: temp = curr.val
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
            result.append(temp)
        return result