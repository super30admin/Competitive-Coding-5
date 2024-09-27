# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        
        queue = deque()
        queue.append(root)
        
        while queue:
            count = len(queue)
            maxvalue = float('-inf')
            for i in range(count):
                element = queue.popleft()
                maxvalue = max(maxvalue,element.val)
                if element.left!=None:
                    queue.append(element.left)
                if element.right!=None:
                    queue.append(element.right)
            result.append(maxvalue)
            
        return result
        
        
        