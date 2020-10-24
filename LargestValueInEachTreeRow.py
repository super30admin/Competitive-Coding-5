# -*- coding: utf-8 -*-
"""
Created on Sat Oct 24 18:02:53 2020

@author: Tripti Santani

Algorithm Used - BFS

Step 1: Checked for base case i.e. if root is null, return root
Step 2: Declare output list to store the largest value in each row and a queue for BFS approach
Step 3: Start a while loop and assign length of queue in q_size and assign the maximum negative integer value
        to max_value.
Step 4: Start a for loop for getting all the nodes for a particular level, pop the leftmost value and
        store the maximum value in max_value
Step 5: Append left node of the current node to queue. Append right node to the current node to queue
Step 6: Append the max_value when out of the for loop.
Step 7: Return the output list

Time Complexity- O(N)
Space Complexity - O(max height) // for every level, one value will be appended to the output.

Code accepted on leetcode
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
        
    def largestValues(self, root: TreeNode) -> List[int]:
        
        if root == None:
            return root
        
        output=[]
        queue=deque()
        queue.append(root)
        
        while(queue):
            q_size = len(queue)
            max_value = -2147483648 
            for i in range(0,q_size):
                curr = queue.popleft()
                if curr.val>max_value:
                    max_value = curr.val     
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                    
            output.append(int(max_value))
            
        return output
        