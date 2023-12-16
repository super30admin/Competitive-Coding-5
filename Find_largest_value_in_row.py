# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(N)
# SC: O(H)

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q=deque()
        q.append(root)

        res=[]
        while q:
            size1=len(q)
            max1=-999999999999999999
            for i in range(0,size1):
                h=q.popleft()
                max1=max(max1,h.val)

                if h.left:
                    q.append(h.left)
                
                if h.right:
                    q.append(h.right)
            res.append(max1)

        return res




        