# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC : O(n)
    # SC : O(n)
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = deque()
        q.append(root)
        res = []
        while q:
            temp = []
            cursize = len(q)
            maxval = float('-inf')
            while cursize > 0:
                curNode = q.popleft()
                cursize -= 1
                maxval = max(maxval,curNode.val)
                if curNode.left:
                    q.append(curNode.left)
                if curNode.right:
                    q.append(curNode.right)
            res.append(maxval)
        return res
        