# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC:O(n)
# SC:O(n)

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        queue = []
        result = []

        queue.append(root)
        level = 1

        while queue:
            size = len(queue)
            for i in range(size):
                el = queue.pop(0)

                if len(result) < level:
                    result.append(el.val)
                else:
                    result[level-1] = max(result[level-1],el.val)

                if el.left is not None:
                    queue.append(el.left)

                if el.right is not None:
                    queue.append(el.right)
            level += 1

        return result



