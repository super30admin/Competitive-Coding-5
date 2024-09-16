'''
S30 Big N Problem #70 {Medium}

LC - 515. 
Find Largest Value in Each Tree Row

 Time Complexity : O(n) n=elements in the tree
 Space Complexity : O(n) n=elements in the tree
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No 

 Approach
 
 1. carry out BFS traversal
 2.  add every level, for every element compare it with max value
 3. at end of every level, add it to result set
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res=[]
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        self.res=[]
        self.helper(root)
        
        return self.res
    
    def helper(self,root):
        
        stack=[root]
        
        while stack:
            cnt=len(stack)
            
            maxx=float('-inf')
            for i in range(cnt):
                ele=stack.pop(0)
                
                if ele.left:
                    stack.append(ele.left)
                if ele.right:
                    stack.append(ele.right)
                    
                if ele.val>maxx:
                    maxx=ele.val
            
            self.res.append(maxx)
        
                
                
        
