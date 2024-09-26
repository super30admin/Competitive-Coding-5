'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 515. Find Largest Value in Each Tree Row

# Given the root of a binary tree, return an array of the largest value 
# in each row of the tree (0-indexed).



#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to process N items in the binary tree
#------------------
# Space Complexity: 
#------------------
# O(width(N)) ~ O(N/2) ~ O(N): Max size of queue = width of binary tree which is 
#                              floor of N/2.

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import math
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        self.result = []
        self.largestValuesHelper(root, 0)
        return self.result
    
    def largestValuesHelper(self, curr: TreeNode, level:int) -> None:
        if curr is None:
            return
        
        if len(self.result) == level :
            self.result.append(-(math.inf))
        
        self.result[level] = max(self.result[level] , curr.val)
            
        self.largestValuesHelper(curr.left, level+1)
        self.largestValuesHelper(curr.right, level+1)