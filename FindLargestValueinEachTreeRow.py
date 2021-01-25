# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue and iterate over the queue until it is empty
# Then initialize maxnum to -inf for each level and iterate over the size of the queue for each level
# Pop the node from the queue and check if node has left and right child and append it to queue
# Check if maxnum is less than node value then assign node value to maxnum. That will be the max value for each level
# After each level iteration append the maxnum to res

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return None
        queue = deque([root])
        res = []
        while queue:
            maxnum = -inf
            for i in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                if maxnum < node.val:
                    maxnum = node.val
            res.append(maxnum)
        return res
