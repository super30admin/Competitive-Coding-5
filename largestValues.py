# Time Complexity : O(N)
# Space Complexity : O(lastRowInTree) -> O(N/2) so O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        res = []
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            maxVal = float('-inf')
            for i in range(size):
                curr = queue.popleft()
                
                if maxVal < curr.val:
                    maxVal = curr.val 
                
                if i == size - 1:
                    res.append(maxVal)
                #populate queue
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)        
        return res