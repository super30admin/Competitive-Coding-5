# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    """BFS Implementation
    Time complexity-O(n)
    Space Complexity-O(n)"""
    def largestValues(self, root: TreeNode) -> List[int]:
        q=deque()
        arr=[]
        if not root:
            return arr
        q.append(root)
        while q:
            k=0
            currmax=q[0].val
            size=len(q)
            for j in range(size):
                curr=q.popleft()
                currmax=max(currmax, curr.val)
                print(currmax)
                if j==size-1:
                    arr.append(currmax)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
            k+=1
        return arr
        
                
                
                
                              
        
        