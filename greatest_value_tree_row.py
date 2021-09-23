# // Time Complexity : O(n) 
# // Space Complexity : O(height of the tree) for DFS, O(n) for BFS 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []
        
    def dfs(self,root,level):
        if not root: return 
        
        if len(self.res) == level: 
            self.res.append(root.val)
            
        self.res[level] = max(self.res[level],root.val)
            
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        
        
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        
        # DFS
        # 
        self.dfs(root,0)
        return self.res
    
    
#         # BFS 
#         queue = deque()
#         res = []
        
#         queue.append(root)
        
#         while queue:
#             size = len(queue)
#             max_level = float('-inf')
#             while size:
#                 top = queue.popleft()
#                 max_level = max(max_level,top.val)
#                 if top.left: queue.append(top.left)
#                 if top.right: queue.append(top.right)
#                 size -= 1
#             res.append(max_level)
#         return res