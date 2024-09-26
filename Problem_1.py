# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        q = deque([ ])
        q.append(root)
        result = []
        while q:
            size = len(q)
            maxVal = float("-inf")
            for _ in range(size):
                curr = q.popleft()
                maxVal = max(maxVal, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
            result.append(maxVal)
        
        return result