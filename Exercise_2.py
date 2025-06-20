# S30 Problem #69 Find Largest Value in Each Tree Row
#LeetCode #515 https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        queue = deque()
        queue.append(root) #[1]
        res = [] 

        while queue:
            size = len(queue)
            maxl = float("-inf")

            # itirate over the level
            for i in range(size):
                curr = queue.popleft()
                maxl = max(maxl, curr.val)
                if curr.left:
                    queue.append(curr.left) 
                if curr.right:
                    queue.append(curr.right)
            res.append(maxl)
        return res  