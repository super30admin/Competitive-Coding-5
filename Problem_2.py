"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Traversing the tree by level, iterating every level of the tree, finding the maximum, at each level, and appending it to result,
and appending all the nodes to the queue ,then adding children of each node in the queue
and repeating process until reached to last level 
"""

# Largest value in each row

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        if not root:
            return []
        
        q=collections.deque()
        q.append(root)
        res=[root.val]

        while q:
            size=len(q)
            maxx=float('-inf')

            for i in range(size):
                curr=q.popleft()
                if curr.left:
                    maxx=max(maxx,curr.left.val)
                    q.append(curr.left)
                if curr.right:
                    maxx=max(maxx,curr.right.val)
                    q.append(curr.right)

            if maxx!=float('-inf'):
                res.append(maxx)
        return res   