#Time Complexity : O(N)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return None
        queue = [root]
        li = []
        while queue:
            size = len(queue)
            maxx = float('-inf')
            for i in range(size):
                node = queue.pop(0)
                maxx = max(maxx,node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            li.append(maxx)
            
        return li
            
            