# Time Complexity : O(n) where n is number of elements in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def largestValues(self, root: TreeNode):
        result = []
        if not root:
            return result
        queue = [root]
        while queue:
            max_val = result.append(max(node.val for node in queue)) # current max
            new_queue = [] # initialize a new queue to store val in next level
            for node in queue:
                for child in (node.right, node.left): # check children of the new root
                    if child:
                        new_queue.append(child)
            queue = new_queue
        return result
