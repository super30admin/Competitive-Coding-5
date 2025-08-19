# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS Approach:
import queue
import math
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        result = []
        q = queue.Queue()
        q.put(root)

        while not q.empty():
            max_val = -math.inf
            size = q.qsize()

            for i in range(0,size):
                curr = q.get()
                max_val = max(curr.val, max_val)

                # add the next level elements to the queue
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
            
            result.append(max_val)

        return result



# DFS Approach:
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.dfs(root,0)
        return self.result

    # recursion function
    def dfs(self, root: Optional[TreeNode], depth: int):

        # base
        if root == None:
            return []

        # logic
        if len(self.result) == depth:
            self.result.append(root.val)
        else:
            self.result[depth] = max(root.val, self.result[depth])

        # recursion
        self.dfs(root.left, depth + 1)
        self.dfs(root.right,depth + 1)
