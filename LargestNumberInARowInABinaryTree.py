# Time Complexity : O(N)
# Space Complexity : O(H) where H is the height of the tree

# DFS Approach

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        self.helper(result, root, 0)
        return result

    def helper(self, result, root, level):
        if root == None:
            return
        if len(result) == level:
            result.append(root.val)
        else:
            result[level] = max(result[level], root.val)

        self.helper(result, root.left, level + 1)
        self.helper(result, root.right, level + 1)

# BFS Approach

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        queue = deque()
        result = []
        queue.append(root)
        while len(queue) != 0:
            size = len(queue)
            maximum = -float('inf')
            for i in range(size):
                node = queue.popleft()
                if node.val > maximum:
                    maximum = node.val
                if node.left != None:
                    queue.append(node.left)
                if node.right != None:
                    queue.append(node.right)
            result.append(maximum)
        return result



