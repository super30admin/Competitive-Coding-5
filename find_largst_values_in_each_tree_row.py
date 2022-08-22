# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:  
    def __init__(self):
        self.res = []
        
    def largestValues(self, root):   
        
        if not root:
            return 
        queue = deque()
        queue.append(root)
        self.dfs(root, 0)
        return self.res
        
    def dfs(self, root, depth):
        if len(self.res) == depth:
            self.res.append(root.val)
        else:
            self.res[depth] = max(root.val, self.res[depth])            
        if root.left:
            self.dfs(root.left, depth + 1)           
        if root.right:
            self.dfs(root.right, depth + 1)
        return self.res
        
