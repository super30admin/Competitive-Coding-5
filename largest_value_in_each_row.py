# O(N) time and space

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        level_order = []
        queue = []
        queue.append(root)
        while len(queue):
            current_max = float("-inf")
            for i in range(len(queue)):
                node = queue.pop(0)
                if node is None:
                    continue
                current_max = max(current_max,node.val)
                queue.append(node.left)
                queue.append(node.right)
            if current_max != float("-inf"):
                level_order.append(current_max)
        return level_order
        