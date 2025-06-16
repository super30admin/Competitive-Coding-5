"""
Traverse the tree level-by-level applying BFS
At each level, track max value
Append it to the result list
"""
"""
Time Complexity: O(N) – Visit every node once
Space Complexity: O(W) – W = max width of the tree
"""


from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class largestValueTreeRow:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:

        res = []

        if root == None:
            return res

        q = deque()
        q.append(root)
  
        while q:
            size = len(q)
            maxval = -float('inf')
            for _ in range(size):
                node = q.popleft()
                maxval = max(maxval,node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(maxval)
        
        return res


if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(3)
    root.right = TreeNode(2)
    root.left.left = TreeNode(5)
    root.left.right = TreeNode(3)
    root.right.right = TreeNode(9)

    obj = largestValueTreeRow()
    print(obj.largestValues(root))  

    
        