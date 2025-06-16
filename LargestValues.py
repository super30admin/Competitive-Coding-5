# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(n)
# Time Complexity - o(n)
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        res = []

        if not root:
            return res

        q = deque()
        q.append(root)

        while q:
            
            max_num = float('-inf')
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                if node:
                    max_num = max(max_num,node.val)
                if node and node.left:
                    q.append(node.left)
                if node and node.right:
                    q.append(node.right)

            res.append(max_num)

        return res