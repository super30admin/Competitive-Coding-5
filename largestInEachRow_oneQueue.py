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
        queue = deque()  # new double ended queue to pop or append from either side
        queue.append(root)  # first value is the root
        while len(queue) > 0:
            size = len(queue)
            max_value = (
                min(node.val for node in queue))  # initialize with the min value to append later with max value
            for i in range(size):
                node = queue.popleft()
                if node.val > max_value:  # compare the current node value with current max value
                    max_value = node.val
                if node.right is not None:
                    queue.append(node.right)
                if node.left is not None:
                    queue.append(node.left)

            result.append(max_value)  # append the latest max value to the result list
        return result
