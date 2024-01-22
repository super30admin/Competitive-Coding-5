#Time Complexity :O(N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : yes

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
from ast import List
import collections


class Solution:
    def largestValues(self, root: [TreeNode]) -> List[int]:
        result = []
        if root is None:
            return result
        
        q = collections.deque()
        q.append(root)
        result.append(root.val)

        while q:
            qlen = len(q)
            level =[]
            
            for i in range(qlen):
                curr = q.popleft()

                if curr.left:
                    q.append(curr.left)
                    level.append(curr.left.val)
                if curr.right:
                    q.append(curr.right)
                    level.append(curr.right.val) 
            if level:
                result.append(max(level))
        return result


        
