# Time Complexity = O(N)
# Space complexity = O(2^H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = Queue()
        q.put(root)
        result = []
        if root is None:
            return result
        while not q.empty():
            size = q.qsize()
            max = -math.inf 
            for i in range(size):
                curr = q.get()
                if curr.val >= max:
                    max = curr.val
                if curr.left is not None:
                    q.put(curr.left)
                if curr.right is not None:
                    q.put(curr.right)
            result.append(max)
        return result
