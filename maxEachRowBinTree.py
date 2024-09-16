'''
Time Complexity -->
O(n)

Space Complexity -->
O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        #BFS approach
        if root==None:
            return []
        res = []
        q = [root]
        #res.append(root.val)
        while q:
            l = len(q)
            v = float('-inf')
            for i in range(l):
                node = q.pop(0)
                if node.val>v:
                    v = node.val
                
                
                
                if node.left!=None:
                    
                    q.append(node.left)
                    
                if node.right!=None:
                    q.append(node.right)
            res.append(v)
        return res
        