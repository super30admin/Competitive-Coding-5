# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Perform a level-order traversal (BFS) of the binary tree using a queue.
# At each level, find the maximum value among all nodes in that level.
# Add the maximum value of each level to the result list.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        from collections import deque
        if not root:
            return []
        queue = deque()
        output = []
        queue.append(root) #[1]
        while queue:
            size = len(queue)
            max_value = float("-inf")
            for i in range(size):
                curr = queue.popleft() #1
                if curr.val > max_value:
                    max_value = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            output.append(max_value)
        return output
                

        