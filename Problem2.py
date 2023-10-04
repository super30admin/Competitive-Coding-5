# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return
        q, ans = collections.deque([root]), []
        while q:
            size = len(q)
            curr_max = float('-inf')
            for _ in range(size):
                curr = q.popleft()
                curr_max = max(curr.val, curr_max)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            ans.append(curr_max)
        return ans