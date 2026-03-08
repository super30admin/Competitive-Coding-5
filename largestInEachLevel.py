from typing import Optional, List
from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BFSSolution:
# TC: O(N) where N is the number of nodes in the tree
# SC: O(W) where W is the maximum width of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

    # BFS
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = deque()
        q.append(root)
        result = []

        while len(q):
            size = len(q)
            maximum = float('-inf')
            for _ in range(size):
                curr = q.popleft()
                maximum = max(maximum, curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            result.append(maximum)
        
        return result

class DFSSolution:
# TC: O(N) where N is the number of nodes in the tree
# SC: O(H) where H is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No
    # DFS
    def __init__(self):
        self.result = []

    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root, 0)
        return self.result

    def dfs(self, root: Optional[TreeNode], depth: int) -> None:
        if root is None:
            return
        if depth == len(self.result):
            self.result.append(root.val)
        else:
            self.result[depth] = max(root.val, self.result[depth])
        
        if root.left is not None:
            self.dfs(root.left, depth+1)
        
        if root.right is not None:
            self.dfs(root.right, depth+1)