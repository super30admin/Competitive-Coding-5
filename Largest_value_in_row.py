'''
TC = O(n)
SC = O(n) 
Approach = using BFS level order traversal
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        result = []
        queue = deque([root])
        while queue:
            l_size = len(queue)
            max_val = float('-inf')
            for _ in range(l_size):
                node = queue.popleft()
                max_val = max(max_val, node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(max_val)
        return result

        