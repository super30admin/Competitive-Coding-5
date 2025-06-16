# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None:
            return result
        q = deque()
        q.append(root) # [1,3,2,5,3,null,9]
        while q:
            size = len(q)
            mx = -math.inf
            for i in range(size):
                curr = q.popleft()
                mx = max(curr.val,mx)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            result.append(mx)
        return result
