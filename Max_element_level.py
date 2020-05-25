// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
DFS approach.
1)Traverse through the tree and store the count at each and every node.
2)with this count we can track the max element at each and every level.
3)store the node values at each and every level in a list.
#DFS
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity --> o(n)
#space complexity --> o(h)
class Solution:
    def __init__(self):
        self.out=[]
        
    def dfs(self,root,count):
        if root==None:
            return
            
        #if the level count is equal to the array length then we add it to the list.
        if count==len(self.out):
            self.out.append(root.val)
            
        #we try to get the max value at each and every level.
        else:
            self.out[count]=max(root.val,self.out[count])
        
        self.dfs(root.left,count+1)
        self.dfs(root.right,count+1)
        
    def largestValues(self, root: TreeNode) -> List[int]:
        if root==None:
            return []
        
        self.dfs(root,0)
        return self.out

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
BFS approach.

// Your code here along with comments explaining your approach:     
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time complexity --> o(n)
#space complexity --> o(n)
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root==None:
            return []
        
        queue=deque([root])
        out=[]
        
        while len(queue)!=0:
            size=len(queue)
            maxi=float('-inf')
            for i in range(size):
                node=queue.popleft()
                maxi=max(maxi,node.val)
                if node.left!=None:
                    queue.append(node.left)
                if node.right!=None:
                    queue.append(node.right)
            out.append(maxi)
        return out

