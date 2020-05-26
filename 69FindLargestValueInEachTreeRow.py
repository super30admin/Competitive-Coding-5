"""
// Time Complexity :O(n) Visiting each node ones.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Traverse the tree in BFS and compare the root value with maximumval.
Update the values accordingly.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # edge case
        if root is None:
            return []

        result = []


        queue = deque()
        queue.append(root)

        while queue:
            """
            #Size variable is required as need to process distinct group of values i.e
            max value at each level
            """
            size = len(queue)
            maximumval = -float('inf')
            for i in range(size):
                node = queue.popleft()
                maximumval = max(maximumval,node.val)
                if node.left is not None:   # append left child
                    queue.append(node.left)
                if node.right is not None: #append right child
                    queue.append(node.right)

            result.append(maximumval) # adding maximum in final result
        return result                   # return final result
