# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        # level order and take max
        res = []
        q = []
        q.append(root)
        while q:
            size = len(q)
            li = []
            for i in range(size):
                curr = q.pop(0)
                if curr:
                    li.append(curr.val)
                if curr and curr.left:
                    q.append(curr.left)
                if curr and curr.right:
                    q.append(curr.right)
            if li:
                res.append(max(li))
        return res
