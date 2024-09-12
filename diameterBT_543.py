# Adding this as well because I was asked the following question in the interview
# Ques: https://leetcode.com/problems/diameter-of-binary-tree/submissions/

# // Time Complexity : O(n)
# // Space Complexity : O(n), recursive stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        #global max
        self.max = 0 
    
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        
        if not root:
            return self.max
        
        self.recur(root)
        
        #return num of edges=nodes-1
        return (self.max-1)
        
        
    def recur(self, root:TreeNode):
        
        if not root:
            return 0
        
        #recur on left and right and get max path lengths
        left = self.recur(root.left)
        right = self.recur(root.right)
        
        #update global path length if max value is lesser 
        self.max = max(self.max, (left + right +1))
        
        return max(left, right)+1
        