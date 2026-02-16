"""
time complexity: O(n) where n is the number of nodes in the tree. We visit each node once to find the largest value in each row.
space complexity: O(h) where h is the height of the tree.
We use a depth-first search (DFS) approach to traverse the tree. We maintain a list to store the largest values for each depth level.
As we traverse the tree, we compare the current node's value with the existing value in the result list for the current depth. 
If the current node's value is larger, we update the result list. 
We then recursively call the helper function for the left and right child nodes, incrementing the depth by 1.
"""
from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root,0)
        return self.result
    
    def helper(self,root,depth):
        if not root:
            return
        if len(self.result)==depth: 
            self.result.append(root.val)
        else:
            if self.result[depth]<root.val:
                self.result[depth]=root.val
        self.helper(root.left, depth+1)
        self.helper(root.right, depth+1)

        