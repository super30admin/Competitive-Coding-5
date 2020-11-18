"""
time complexity - O(N)
Space complexity - O(N)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_DFS:
    def largestValues(self, root: TreeNode) -> List[int]:
        self.res=[]
        self.dfs(root,0)
        return self.res
    
    def dfs(self, root,level):
        if root is None:
            return 
        
        if (len(self.res)==level):
                self.res.append(root.val)
        else:
            if root.val>self.res[level]:
                self.res[level]=root.val
        
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)