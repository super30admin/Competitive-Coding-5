# Time complexity : O(n)
# Space complexity : O(n) --> for queue
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        # if root is null, return empty list
        if not root:
            return res
        # insert root node into the queue
        q = deque([root])
        while q:
            max_val = float('-inf')
            # traverse the queue for each level, so we calculate the len of q
            for i in range(len(q)):
              # pop the element and find max at each level
              # add the left and right child if any, append them to the queue 
                curr = q.popleft()
                max_val = max(max_val, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(max_val)
        # return result
        return res
                
