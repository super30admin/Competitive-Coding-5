# Time Complexity: O(n) for BFS and DFS
# Space Complexity: O(n) for BFS and O(h) for DFS (where h is the height of the tree)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans = []
        
    def dfs(self,root,level):
        if not root:
            return
        if level == len(self.ans):
            self.ans.append(root.val)
        if self.ans[level] < root.val:
            self.ans[level] = root.val
        
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
#         if not root:
#             return []
        
#         level = 0
        
#         self.dfs(root,level)
        
#         return self.ans
        
        if not root:
            return []
        
        ans = []
        
        q = collections.deque()
        q.appendleft(root)
        
        while q:
            size = len(q)
            
            maxi = -float('inf')
            
            for i in range(size):
                curr = q.popleft()
                if curr.val > maxi:
                    maxi = curr.val
                if curr.left:
                    q.appendleft(curr.left)
                if curr.right:
                    q.appendleft(curr.right)
            ans.append(maxi)
        
        return ans
        
    

    