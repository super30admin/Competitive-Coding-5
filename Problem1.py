# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        result = []
        q = []
        q.append(root)
        while q:
            size = len(q)
            max_ = float('-inf')
            for node in range(size):
                node = q.pop(0)
                max_ = max(max_, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(max_)
        return result
