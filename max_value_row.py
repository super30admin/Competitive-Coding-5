# Time Complexity : Add - O(n)
# Space Complexity :O(2^h) - O(n/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''

1. use DFS and append the nodes value initially
2. If value corresponding to a level is already present, that means that level has already been traversed, so we must replace
   to that depth, so a minimum of value present in lsit and current root.val must be put

'''
class Solution:
    
    def __init__(self):
        self.result = []
        
    def largestValues(self, root: TreeNode) -> List[int]:
        
        self._helper(root, -1)
        
        return self.result
        
        
    def _helper(self, root, level):
        
        if root is None:
            return
  
        level += 1
        if len(self.result) >= level+1:
            if self.result[level] < root.val:
                self.result[level] = root.val
        else:
            self.result.append(root.val)

      
        self._helper(root.left, level)
        self._helper(root.right, level)
        