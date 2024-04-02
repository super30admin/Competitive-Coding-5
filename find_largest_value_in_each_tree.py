# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from collections import Optional, TreeNode, deque, List
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result 

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            max_val = float('-inf')

            for i in range(size):
                curr = q.popleft()
                max_val = max(max_val, curr.val)

                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)

            result.append(max_val)
        
        return result