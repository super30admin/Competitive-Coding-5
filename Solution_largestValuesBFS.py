"""
Time complexity - O(N)
Space complexity - O(N)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_largestValuesBFS:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        q=[]
        res=[]
        q.append(root)
        while q:
            size=len(q)
            max1=float('-inf')
            for i in range(size):
                curr=q.pop(0)
                if curr.val> max1:
                    max1=curr.val
                if  curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(max1)
        return res
                
        