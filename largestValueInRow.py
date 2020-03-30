'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a queue and iterate through the elements in a BFS manner, at each level keep track of the highest
element and add that to the result array.
'''
import math


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root == None:
            return []

        queue = [root]
        res = []
        max1 = 0
        while len(queue) != 0:
            maxM = -math.inf

            for i in range(0, len(queue)):
                first = queue[0]
                queue = queue[1:]

                if first.left != None:
                    queue.append(first.left)

                if first.right != None:
                    queue.append(first.right)

                if first.val > maxM:
                    maxM = first.val

            res.append(maxM)

        return res