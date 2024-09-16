# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do a BFS and at each level store the max value by iterating through elements at that level and comparing it
# to curremt max

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if not root: return []
        q = deque()
        q.append(root)
        while len(q)>0:
            size = len(q)
            maxi = -math.inf
            for x in range(size):
                current = q.popleft()
                if current.val > maxi:
                    maxi = current.val
                if current.left:
                    q.append(current.left)
                    
                if current.right:
                    q.append(current.right)
            result.append(maxi)
            
        return result