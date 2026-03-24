# https://leetcode.com/problems/find-largest-value-in-each-tree-row/

# TC: O(n)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        res = []

        if root is None:
            return []

        q.append(root)

        while q:
            size = len(q)
            largest = float('-inf')
            for i in range(size):
                qroot = q.popleft()
                largest = max(largest, qroot.val)

                if qroot.left:
                    q.append(qroot.left)
                if qroot.right:
                    q.append(qroot.right)

            res.append(largest)

        return res
    

