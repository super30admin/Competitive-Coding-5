from typing import List
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root) -> List[int]:
        self.result = []
        self.helper(root, 0)
        return self.result

    def helper(self, root, level):
        if not root:
            return

        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = max(self.result[level], root.val)

        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)

# TC - O(n)
# SC - O(h)