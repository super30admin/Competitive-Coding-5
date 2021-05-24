# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:

        if root is None:
            return None

        result = []
        q = []

        q.append(root)

        while q:
            maxValue = -float("inf")
    #       size = len(q)
            for i in range(len(q)):
                curr = q.pop(0)
                maxValue = max(curr.val, maxValue)

                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)

            result.append(maxValue)

        return result
        
#         O(n) is time and space complexity
