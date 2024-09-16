    
# Time Complexity = O(N)
# Space Complexity = O(N)
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        q = list()
        result = list()
        if root == None:
            return 
        q.append(root)
        
        while q:
            size = len(q)
            maxVal = float("-inf")
            for i in range(size):
                curr = q.pop(0)
                maxVal = max(maxVal,curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)       
            result.append(maxVal)
        
        return result

            