# Time Complexity: O(n) where n is the number of nodes in the tree.
# Space Complexity: O(n) where n is the number of nodes in the tree.
# Did this code successfully run on Leetcode : Yes
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
        result = []
        queue = deque()     # Initialize a queue.
        queue.append(root)
        while queue:        # True if queue has elements in it.
            maxvalue = float('-inf')
            size = len(queue)
            for i in range(size):
                curr_node = queue.popleft()
                if curr_node.val > maxvalue:
                    maxvalue = curr_node.val
                if curr_node.left:      # Check if current node has left child.
                    queue.append(curr_node.left)
                if curr_node.right:     # Check if current node has right child.
                    queue.append(curr_node.right)
            result.append(maxvalue)
        return result
            
        