#https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root==None:
            return []
        def dfs(root,level):
            if root==None:
                return
            if level==len(self.result):
                self.result.append(root.val)
            else:
                print(level, self.result)
                if self.result[level]<root.val:
                    self.result[level]=root.val
            dfs(root.left,level+1)
            dfs(root.right,level+1)
            
        self.result=[]
        dfs(root,0)
        return self.result
        #Time O(n)
        #Space O(h) h=height
        
#         #queue
#         queue=deque()
        
#         result=[]
#         queue.append(root)
#         while(len(queue)>0):
#             sz=len(queue)
#             mx=float("-inf")
            
#             while(sz>0):
#                 sz-=1
#                 v=queue.popleft()
#                 mx=max(mx,v.val)
#                 if v.left:
#                     queue.append(v.left)
                    
#                 if v.right:
#                     queue.append(v.right)
#             result.append(mx)
            
#         return result
