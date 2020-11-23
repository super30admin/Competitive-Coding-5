"""
Time Complexity : O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
We do a level order traversal and keep a max variable at each level which we update in case we find 
a greater value.
"""

from collections import deque


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            maxx = float('-inf')
            for i in range(size):
                curr = q.popleft()
                if curr.val > maxx:
                    maxx = curr.val
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(maxx)
        return result
