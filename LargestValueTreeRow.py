# Time Complexity : O(n)
# Space Complexity : O(n) for using the queue data structure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition here is to do a level order traversal(BFS) and then at each level determine the largest value

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        queue = deque()
        result = []
        if not root:
            return result
        queue.append(root)
        while queue:
            size = len(queue)
            maxValue = float('-inf')
            for i in range(size):
                curr = queue.popleft()
                # Need to find the largest value and append into a list after the loop
                maxValue = max(maxValue, curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(maxValue)

        return result

