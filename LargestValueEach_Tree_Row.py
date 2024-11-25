"""
Explanation:
Use breadth-first traversal (BFS) to traverse the tree level by level.
Maintain a queue to store nodes and their corresponding depth.
As we traverse each level, calculate the maximum value on-the-fly.
# Time Complexity: O(N), where N is the total number of nodes in the tree. We visit each node once during traversal.
# Space Complexity: O(W), where W is the maximum width of the tree (max number of nodes at any level).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        queue = deque([(root, 0)])  # Queue to store nodes along with their depth
        result = []  # To store the largest values for each row
        
        while queue:
            node, depth = queue.popleft()
            
            # If we encounter a new depth, initialize its largest value
            if len(result) == depth:
                result.append(node.val)
            else:
                # Update the largest value for the current depth
                result[depth] = max(result[depth], node.val)
            
            # Add children to the queue with updated depth
            if node.left:
                queue.append((node.left, depth + 1))
            if node.right:
                queue.append((node.right, depth + 1))
        
        return result
       