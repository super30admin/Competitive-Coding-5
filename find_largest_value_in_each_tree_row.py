# https://leetcode.com/problems/find-largest-value-in-each-tree-row/

# Time Complexity- O(n) Space Complexity- O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque
import math
class Solution:
    def largestValues(self, root) -> list[int]:
        # initilaise the result list
        result = []
        # initialise the deque
        q = deque()
        # check the edge case
        if root is None:
            return result
        # append the root into the queue
        q.append(root)

        while q:
            # take the size of the queue as we need to go level by level
            size = len(q)
            # initialise the maximum length variable with negative value
            max_ele = float('-inf')
            # iterate over the size
            for i in range(size):
                # pop the left element from the deque
                curr = q.popleft()
                # compare the poped element and max length and update with the new value
                max_ele = max(max_ele, curr.val)
                # check the left part
                if curr.left:
                    q.append(curr.left)
                # check the right part
                if curr.right:
                    q.append(curr.right)
            # update the result list
            result.append(max_ele)
        # return the result
        return result
                   