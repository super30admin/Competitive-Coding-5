# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root):
        if not root:
            return root
        res = []
        q = deque()
        q.append(root)

        while q:
            maxv = -float('inf')
            for i in range(len(q)):
                curr = q.popleft()
                maxv = max(maxv,curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            res.append(maxv)
        return res
    
#TC: O(n)
#SC: O(n)