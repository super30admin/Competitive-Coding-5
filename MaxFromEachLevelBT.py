# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root) :
        if root == None:
            return

        queue = []
        result = []

        queue.append(root)

        while queue:
            size = len(queue)
            maxv = float("-inf")
            for i in range(size):
                curr = queue.pop(0)
                maxv = max(curr.val, maxv)

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)

            result.append(maxv)
        return result
