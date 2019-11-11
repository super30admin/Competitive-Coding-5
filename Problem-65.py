# Leet code -515 - Find the largest value in each tree row - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
# Approach - BFS - At each level we calculate the maximum value and append it to the array list
#Time complexity -O(N)
#space complexity -O(N)




# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []
        queue=deque()
        res=[]
        queue.append(root)
        
        while queue:
            size=len(queue)
            
            level_max = float('-inf')
            for i in range(len(queue)):
                curr=queue.popleft()
                level_max=max(level_max,curr.val)
                if curr.left:
                    queue.append(curr.left)
                    
                if curr.right:
                    queue.append(curr.right)
                    
            res.append(level_max) 
            
        return res
        
       
    
 from collections import deque

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #edge case
        res=[]
        queue=deque()
        if not root: return res
        queue.append(root)
        
        while queue:
            size=len(queue)
            max=float("-inf")
            for i in range(size):
                curr=queue.popleft()
                if curr.val>max:
                    max=curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            res.append(max)
        return res
                
        
        
