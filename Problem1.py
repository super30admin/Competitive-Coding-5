# 515. Find Largest Value in Each Tree Row
# TC: O(N)
# SC: O(N)
# Yes, this worked in leetcode


from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = Queue()
        q.put(root)
        res = []
        # maxi = float("-inf")
        while not q.empty():
            size = q.qsize()
            # level = []
            maxi = float('-inf')
            for i in range(size):
                Node = q.get()
                maxi = max(maxi, Node.val)
                if Node.left:
                    q.put(Node.left)
                if Node.right:
                    q.put(Node.right)
            # maxi = max(level)
            res.append(maxi)
        return res


