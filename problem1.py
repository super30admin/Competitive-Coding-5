##TimeComplexity : O(n)
##SpaceComplexity : O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None: return None
        from collections import deque
        result=[]
        q=deque()
        q.append(root)
        while len(q)!=0:
            s=len(q)
            l=[]
            for i in range(s):
                cur=q.popleft()
                l.append(cur.val)
                if cur.left!=None: q.append(cur.left)
                if cur.right!=None: q.append(cur.right)
            result.append(l)
        for i in range(len(result)):
            if i%2!=0: result[i]=result[i][::-1]
        return result