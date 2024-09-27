# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return 
        
        res = []
        q = deque()
        q.append(root)

        while q:
            maxVal = -float('inf')
            for i in range(len(q)):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                maxVal = max(maxVal, curr.val)
            
            res.append(maxVal)
        return res
