# Time Complexity: O(n) where n is the number of nodes in the tree
# Space Complexity: O(n) because of the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We use a queue to solve this problem. We iterate through the tree level by level and keep track of 
the size of the queue. And we get the max value of the level and add it to the answer array. We return the answer array.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None: return []

        answer = []

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            level_max = float('-inf')
            for _ in range(size):
                curr = q.popleft()
                if curr.left != None: q.append(curr.left)
                if curr.right != None: q.append(curr.right)
                level_max = max(level_max, curr.val)

            answer.append(level_max)

        return answer