"""
TC -> O(n) where n is the number of nodes
SC -> O(n) , queue size
Logic:
Use BFS traversal. For each node in a level, compare with max_value and update if the new node is greater.
After each level is processed, add to result list
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        def bfs(root):
            queue = deque([root])
            res = []
            while (queue):
                size = len(queue)
                max_val = -float('inf')
                for _ in range(size):
                    node = queue.popleft()
                    max_val = max(max_val, node.val)
                    if node.left:
                        queue.append(node.left)
                    if node.right:
                        queue.append(node.right)
                res.append(max_val)
            return res

        return bfs(root) if root else []
