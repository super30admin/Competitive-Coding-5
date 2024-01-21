'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
I traverse thru the tree using BFS and at each level I try to find the max element before moving onto the next level

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = collections.deque()
        q.append(root)
        res = []

        while q:
            temp = float('-inf')
            length = len(q)

            for i in range(length):
                node = q.popleft()
                if node:
                    temp = max(temp,node.val)
                    q.append(node.left)
                    q.append(node.right)

            if temp > float('-inf'):
                res.append(temp)

        return res