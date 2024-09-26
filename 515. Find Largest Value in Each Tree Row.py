# // Time Complexity : O(n)
# // Space Complexity : O(2^height)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Run a level order traversal and keep comparing every element at that level
	# Add the result at the end of the level and return the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        res = []
        if root==None:
            return res
        
        Queue = deque()
        Queue.append(root)

        while Queue:
            size = len(Queue)
            Rmax = float('-inf')
            
            for i in range(size):
                CurrNode = Queue.popleft()
                if CurrNode.val > Rmax:
                    Rmax = CurrNode.val
                if CurrNode.left != None:
                    Queue.append(CurrNode.left)
                if CurrNode.right != None:
                    Queue.append(CurrNode.right)
            res.append(Rmax)
        return res