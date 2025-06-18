'''
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
'''

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# time = O(n)
# space = O(n)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # None case
        if not root:
            return []

        # init result, queue
        result = []
        q = deque()

        q.append(root)

        # loop over queue
        while q:
            temp = float('-inf')
            len_q = len(q)
            # loop over level
            for _ in range(len_q):
                node = q.popleft()
                # save max in temp
                temp = max(temp, node.val)
                # add children
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            result.append(temp)
        
        return result

