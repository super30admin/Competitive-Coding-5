# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional


class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if root == None:
            return result

        queue = Deque()
        queue.append(root)

        while len(queue):
            qLen = len(queue)  # number of elements in the current level
            # initiate a maximum value of this level
            # as the negative infinity
            temp = float('-inf')

            for i in range(qLen):
                node = queue.popleft()

                # compare the value of this node to the maximum value seen so far in this level
                temp = max(temp, node.val)

                # append nodes for the next level
                if node.left != None:
                    queue.append(node.left)

                if node.right != None:
                    queue.append(node.right)

            # append the maxium node value of this level
            result.append(temp)
            print(temp)

        return result
