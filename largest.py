# Time Complexity : O(N) where N is the number of nodes in the  tree
# Space Complexity : O(N) where N is the number of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to traverse the tree level by level. For each level, I am keeping track of the maximum value seen so far.
# At the end of each level, I append the maximum value to the answer list. Finally, I return the answer list.

from collections import deque
from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        ans = []
        q = deque([root])
        while q: 
            maxy = float('-inf')
            for _ in range(len(q)):
                node = q.popleft()
                maxy = max(maxy,node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            ans.append(maxy)
        return ans

        