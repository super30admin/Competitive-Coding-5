# Definition for a binary tree node.
"""

    Name : Shahreen Shahjahan Psyche
    Time : O(N)
    Space : O(N)

    This code ran successfully for all the test cases in Leetcode.
    
"""

from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # edge case
        if not root:
            return []
        
        from collections import deque
        
        q = deque()
        largest = []
        q.append(root)
        
        # I am traversing the tree in BFS manner. In each level I am keeping 
        # track which is the largest number. When I am done processing each level
        # I am appending the largest value to the output array
        while q:
            size = len(q)
            tmp = float('-inf')
            i = 0
            while(i < size):
                curr = q.popleft()
                if curr.val > tmp:
                    tmp = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                i += 1
            largest.append(tmp)
        
        return largest
        
        
        