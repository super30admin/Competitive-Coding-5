# TC: O(N)
# SC: O(N)

# BFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = list()
        if root is None:
            return self.result
        
        self.dfs(root,0)
        res = list()
        for i in self.result:
            res.append(max(i))
        return res
    
    def dfs(self, root, level):
        if root is None: return
        
        if len(self.result) == level:
            self.result.append([root.val])
        else:
            self.result[level].append(root.val)
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)

# DFS

# TC: O(N)
# SC: O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = list()
        if root is None:
            return self.result
        
        q = list()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            ma = float('-inf')
            for i in range(size):
                curr = q.pop(0)
                ma = max(ma,curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            self.result.append(ma)
        
        return self.result