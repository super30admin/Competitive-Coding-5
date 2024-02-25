# Time Complexity : O(N) where N is number of nodes in the binary tree
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : We can use BFS to traverse each level and
# use a variable to track the largest element in each level, and
# add it to the result after each level is completed.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from queue import Queue
from typing import List


class Solution:
    def largestValues(self, root) -> List[int]:
        if root is None:
            return []

        result = []
        _queue = Queue()
        _queue.put(root)

        while _queue.qsize() > 0:
            cur_size = _queue.qsize()
            cur_max = float("-inf")
            for index in range(cur_size):
                cur_node = _queue.get()
                cur_max = max(cur_node.val, cur_max)
                if cur_node.left is not None:
                    _queue.put(cur_node.left)
                if cur_node.right is not None:
                    _queue.put(cur_node.right)
            result.append(cur_max)
        return result


