#Time Complexity: O(n)
#space complexiity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        res = []
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            lMax = -sys.maxsize-1
            
            for i in range(size):
                curr = q.popleft()
                lMax = max(lMax, curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(lMax)
        
        return res
                
        
