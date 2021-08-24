"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import queue
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        if not root:
            return self.result
        q = queue.Queue()
        # Inititalize queue with the root
        q = deque([root])
        while q:
            max_ = float('-inf')
            # Traverse through the queue and find the max
            # at the same depth while popping the element
            for _ in range(len(q)):
                node = q.popleft()
                max_ = max(max_, node.val)
                # If left node exist add to the queue
                if node.left:
                    q.append(node.left)
                # If right node exist add to the queue
                if node.right:
                    q.append(node.right)
            # Append the maximum to the result
            self.result.append(max_)
        return self.result