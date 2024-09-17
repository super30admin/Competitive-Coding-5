# Time Complexity - O(n)
# Space Complexity - O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = [root]
        maxArr = []

        while q : 
           size = len(q)
           maxVal = float('-inf')           
           for i in range(size):
                curr = q.pop(0)
                maxVal = max(maxVal,curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
           maxArr.append(maxVal)
        return maxArr

            
