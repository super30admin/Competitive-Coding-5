# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def largestValues(self, root: TreeNode) -> List[int]:
        if root==None:
            return None
        
        self.dfs(root,0)
        return self.result

    def dfs(self,root,level):
        if root==None:
            return 
        
        if len(self.result)==level:
            self.result.append(root.val)
        else:
            self.result[level] = max(self.result[level],root.val)
        
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)