_  # Definition for a binary tree node.


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if not root:
            return result

        q = deque([root])

        while q:
            level_max = float("-inf")
            for _ in range(len(q)):

                curr = q.popleft()
                level_max = max(level_max, curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(level_max)

        return result


# time compleity is O(n)
# space compleity is O(n)
