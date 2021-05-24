"""515. Find Largest Value in Each Tree Row
Time Complexity: O(n)
Space Complexity: O(n)"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result =[] # big list
        
    def dfs(self, root: TreeNode,level):
        # base -leaf
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = max(self.result[level],root.val)
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
            
        
    
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return self.result
        
        self.dfs(root,0)
        return self.result
       