# -*- coding: utf-8 -*-
"""
Created on Mon Sep 20 18:17:57 2021

@author: amdoshi
"""

class Solution:
    #BFS
    def findMax(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        #base
        if root == None:
            return result

        result = []
        q = [root]
        
        while(q):
            max_v = float('-inf')
            size = len(q)
            
            for i in range(size):
                #finding current value
                curr = q.pop(0)
                
                if max_v < curr.val:
                    max_v = curr.val
                    
                if curr.left is not None:
                    q.append(current.left)
                    
                if curr.right is not None:
                    q.append(current.right)
                    
            result.append(max_v)
        
        return result
            

                
                

        
        