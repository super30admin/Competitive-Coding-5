'''
Time: 0(n) i.e. no of nodes
Space: 0(n/2) 
'''
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        # base-check
        if root == None:
            return []
        
        # Initialze resultList
        resultList = []
        
        # Initialize lvl
        lvl = 0
        
        # Intialize queue
        queue = deque([])
        
        # enqueue root
        queue.append(root)
        
        # traverse queue
        while len(queue) != 0:
            
            # maintain size 
            # int.max
            size = len(queue)
            
            # iterate till count == size
            for count in range(0,size):
                
                # deque node from the queue
                node = queue.popleft()
                
                # chk if resultList has 'lvl' index
                if lvl == len(resultList):
                    # I don't have a lvl
                    resultList.append(None)
                
                '''Missed base case check'''
                if node == None:
                    continue
                
                # chk and compare resultList[lvl]
                if (resultList[lvl] == None) or (resultList[lvl] < node.val):
                    resultList[lvl] = node.val
                
                # enque children of the node
                if node.left == None and node.right == None:
                    continue
                
                queue.append(node.left)
                queue.append(node.right)
            
            # update lvl
            lvl += 1
            
        
        # return the result
        '''Missed this case as well'''
        return resultList
                
                
                
                
            
        