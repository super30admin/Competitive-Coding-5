# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. Create a queue to perform level order traversal of the tree.
# 2. Initialize an empty list to store the maximum values at each level.
# 3. While the queue is not empty, iteratively process each level of the tree.
# 4. For each level, keep track of the maximum value encountered.
# 5. For each node in the current level, compare its value with the current maximum value.
# 6. Add the left and right children of the current node to the queue for processing in the next level.

# Definition for a binary tree node.
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root):
        # Initialize an empty list to store the maximum values at each level
        res = []
        # Initialize a queue to perform level order traversal
        q = deque()
        # If the root is not None, add it to the queue
        if root:
            q.append(root)

        # While the queue is not empty, process each level of the tree
        while q:
            # Get the number of nodes at the current level
            size = len(q)
            # Initialize a variable to keep track of the maximum value at the current level
            mx = float('-inf')
            # Iterate through each node at the current level
            for i in range(size):
                # Pop the node from the queue
                node = q.popleft()
                # Compare its value with the current maximum value and update if necessary
                mx = max(mx, node.val)
                # Add the left and right children of the current node to the queue for processing in the next level
                if node.right:
                    q.append(node.right)
                if node.left:
                    q.append(node.left)
            # Append the maximum value of the current level to the result list
            res.append(mx)
        # Return the list of maximum values at each level
        return res