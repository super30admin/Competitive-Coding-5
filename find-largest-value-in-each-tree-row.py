# #DFS: recursion stack
# #TC = O(n), visit each node once, at each node, perform O(1) work
# #SC = O(h) for recursion call on stack (h is height of tree)
# class Solution:
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         result = []
#         self.dfs(root, 0, result)
#         return result
#     def dfs(self, node: Optional[TreeNode], level: int, result: List[int]):
#         if not node:
#             return
#         # First time at this level — append value
#         if level == len(result):
#             result.append(node.val)
#         else:
#             # Already visited this level — update max
#             result[level] = max(result[level], node.val)
#         # Recurse to left and right children
#         self.dfs(node.left, level + 1, result)
#         self.dfs(node.right, level + 1, result)

#BFS: deQueue
#TC = O(n) visit each node once, at each node perform O(1) work
#SC = O(n/2) = O(n) in perfect(complete) Binary Tree, the final row has O(n/2) nodes, all of which will be in queue.
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        queue = deque() #simple BFS queue #queue = deque([root])
        queue.append(root)
        if not root:
            return result
        while queue:
            size = len(queue)
            max_val = float('-inf')
            for i in range(size):
                curr = queue.popleft()
                max_val = max(max_val, curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(max_val)
        return result