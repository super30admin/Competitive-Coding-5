# Time complexity - O(n)
# Space complexity - O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        if root:
            queue = deque([root])
            while queue:
                val = float('-inf')
                for _ in range(len(queue)):
                    node = queue.popleft()
                    val = max(val, node.val)
                    node.left and queue.append(node.left)
                    node.right and queue.append(node.right)
                result.append(val)
        return result

