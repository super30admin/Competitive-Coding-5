# 515. Find Largest Value in Each Tree Row
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = deque([root])
        result = []

        if not root:
            return result

        while q:
            size = len(q)
            max_ = float('-inf')
            for _ in range(size):
                curr = q.popleft()
                if curr.val > max_:
                    max_ = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            result.append(max_)

        return result



        