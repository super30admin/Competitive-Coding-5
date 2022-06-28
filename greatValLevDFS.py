#Time complexity:O(n)
#space compelxity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self. res = []
        
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root, 0)
        return self.res
    
    def dfs(self, root, level):
        if root is None:
            return
        if len(self.res) == level:
            self.res.append(-sys.maxsize-1)
        self.res[level] = max(self.res[level], root.val)
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
        
