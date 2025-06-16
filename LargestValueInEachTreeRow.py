# // Time Complexity : o(n)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# do a bfs at each level keep track of the maxVal so far and keep adding to the result

from typing import Optional,collections,List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q, res = collections.deque(), []
        if not root : return res
        q.append(root)
        while q :
            size = len(q)
            maxVal = float(1000000)
            for i in range(size):
                curr = q.popleft()
                maxVal = max(maxVal, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(maxVal)
        return res

        
        