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
import collections
import math
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        else:
            queue = collections.deque([root])
            while len(queue) > 0:
                size = len(queue)
                max_val_level = - (math.inf)
                for i in range(size):
                    
                    curr = queue.popleft()
                    if curr is not None:
                        max_val_level = max(max_val_level, curr.val)

                        queue.append(curr.right)
                        queue.append(curr.left)
                        
                if max_val_level > -(math.inf):
                    result.append(max_val_level)
            
            return result
            
        